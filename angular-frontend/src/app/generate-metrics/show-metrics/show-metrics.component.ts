import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js/auto';
import { jsPDF } from 'jspdf';
import html2canvas from 'html2canvas';
import * as FileSaver from 'file-saver';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rezerwacja} from "../../rezerwacja.model";

@Component({
  selector: 'app-show-metrics',
  templateUrl: './show-metrics.component.html',
  styleUrls: ['./show-metrics.component.css']
})
export class ShowMetricsComponent implements OnInit {

  public chart: any;
  private data: Rezerwacja[] = [];
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/rezerwacja';
  }

  ngOnInit(): void {
    this.getRezerwacja()

    console.log(this.data[0])

    this.createChart()
  }

  private getRezerwacja() {
    this.getRezerwacjaRequest().subscribe( (data: Rezerwacja[]) => {
        this.data = data
      }
    )
  }

  getRezerwacjaRequest(): Observable<Rezerwacja[]> {
    return this.http.get<Rezerwacja[]>(this.baseUrl);
  }

  createChart(){

    this.chart = new Chart("chart", {
      type: 'bar',
      data: {
        labels: [ 'karta', 'blik', 'apple pay', 'google pay', 'paypal' ],
        datasets: [
          {
            label: "Liczba rezerwacji",
            data: ['467','576', '572', '79', '92',
              '574', '573', '576'],
            backgroundColor: 'blue'
          }
        ]
      },
      options: {
        aspectRatio:2.5
      }
    });
  }

  downloadPdf() {

    html2canvas(<HTMLElement>document.getElementById('chart')).then(canvas => {
      const pdf = new jsPDF();
      pdf.addImage(canvas.toDataURL(), 'PNG', 0, 50, 0, 0);
      pdf.save('chart.pdf');
    });
  }

  downloadPng() {
    html2canvas(<HTMLElement>document.getElementById("chart"),{scale:2}).then(canvas => {
      canvas.toBlob(function(blob) {
        if (blob) {
          FileSaver.saveAs(blob, "chart.png");
        }
      });
    });
  }

  downloadJpeg() {
    html2canvas(<HTMLElement>document.getElementById("chart"),{scale:2}).then(canvas => {
      canvas.toBlob(function(blob) {
        if (blob) {
          FileSaver.saveAs(blob, "chart.jpeg");
        }
      });
    });
  }
}
