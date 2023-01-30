import { Component, OnInit } from '@angular/core';
import {Film} from "../../film.model";
import {Rezerwacja} from "../../rezerwacja.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationService} from "../../services/reservation/reservation.service";
import {Bilet} from "../../bilet.model";
import {BiletService} from "../../services/bilet/bilet.service";

@Component({
  selector: 'app-rezerwacja-confirmed',
  templateUrl: './rezerwacja-confirmed.component.html',
  styleUrls: ['./rezerwacja-confirmed.component.css']
})
export class RezerwacjaConfirmedComponent implements OnInit {

  rezerwacjaId: number;
  rezerwacja!: Rezerwacja;
  bilety: Bilet[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private rezerwacjaService: ReservationService,
              private biletService: BiletService) {

    this.rezerwacjaId = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.rezerwacjaService.getReservationById(this.rezerwacjaId).subscribe(data => {
      this.rezerwacja = data;
    });

    this.biletService.getBiletsByRezerwacja(this.rezerwacjaId).subscribe(
      data => {
        this.bilety = data;
      }
    );
  }

  ngOnInit(): void {
  }

}
