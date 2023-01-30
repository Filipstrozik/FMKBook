import {Component, OnInit} from '@angular/core';
import Chart from 'chart.js/auto';
import {jsPDF} from 'jspdf';
import html2canvas from 'html2canvas';
import * as FileSaver from 'file-saver';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rezerwacja} from "../../rezerwacja.model";
import {ReservationService} from "../../services/reservation/reservation.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-show-metrics',
  templateUrl: './show-metrics.component.html',
  styleUrls: ['./show-metrics.component.css']
})
export class ShowMetricsComponent implements OnInit {

  queryParams: any;
  public chart: any;
  statsAvailable: boolean = true;
  reservations: Rezerwacja[];
  private data: string[] = []

  constructor(private reservationService: ReservationService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.queryParams = params;
      console.log(this.queryParams)
    });

    if (!this.queryParams['startDate'] || !this.queryParams['endDate']) {
      this.statsAvailable = false
    } else {
      let reservationsByDate = this.reservationService.getReservationsByDate(this.queryParams['startDate'], this.queryParams['endDate']);
      reservationsByDate.subscribe(reservations => {
        this.reservations = reservations;

        for (let reservation of this.reservations) {
          this.data.push(reservation.sposobplatnoscinazwametody.id)
        }

        console.log(this.data)

        let count = this.data.reduce(function (acc, curr) {
          if (acc[curr]) {
            acc[curr]++;
          } else {
            acc[curr] = 1;
          }
          return acc;
        }, {});

        console.log(count)

        let countSize = Object.keys(count).length;

        if (countSize == 0) {
          this.statsAvailable = false
        } else {
          this.createChart(count)
        }
      });
    }
  }

  createChart(count: any) {

    this.chart = new Chart("chart", {
      type: 'bar',
      data: {
        labels: Object.keys(count),
        datasets: [
          {
            label: "Liczba rezerwacji",
            data: Object.values(count),
            backgroundColor: 'blue'
          }
        ]
      },
      options: {
        aspectRatio: 2.5
      }
    });
    this.chart.resize(400, 400)
  }

  downloadPdf() {

    html2canvas(<HTMLElement>document.getElementById('chart')).then(canvas => {
      const pdf = new jsPDF();
      pdf.addImage(canvas.toDataURL(), 'PNG', 0, 50, 0, 0);
      pdf.save('chart.pdf');
    });
  }

  downloadPng() {
    html2canvas(<HTMLElement>document.getElementById("chart"), {scale: 2}).then(canvas => {
      canvas.toBlob(function (blob) {
        if (blob) {
          FileSaver.saveAs(blob, "chart.png");
        }
      });
    });
  }

  downloadJpeg() {
    html2canvas(<HTMLElement>document.getElementById("chart"), {scale: 2}).then(canvas => {
      canvas.toBlob(function (blob) {
        if (blob) {
          FileSaver.saveAs(blob, "chart.jpeg");
        }
      });
    });
  }
}
