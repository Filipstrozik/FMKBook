import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TypAbonamentu} from "../../typ-abonamentu.model";

@Component({
  selector: 'app-buy-abonament-details',
  templateUrl: './buy-abonament-details.component.html',
  styleUrls: ['./buy-abonament-details.component.css']
})
export class BuyAbonamentDetailsComponent implements OnInit {
  typyAbonamentu: TypAbonamentu[] = [
    { id: 10, opis: "6 miesięcy", cena: 120},
    { id: 11, opis: "3 miesiące", cena: 150},
    { id: 12, opis: "1 miesiąc", cena: 180}
  ];


  selectedType: TypAbonamentu;
  constructor(private router: Router, private route: ActivatedRoute) {
    console.log(this.route.snapshot.paramMap.get('id'));
    let id: number = parseInt(<string>this.route.snapshot.paramMap.get('id'));

      this.selectedType = this.typyAbonamentu.find(t => t.id == id)!

  }

  ngOnInit(): void {
  }


  cancel() {
    this.router.navigate(['/buyAbonamentCancelled']);
  }

  confirm() {
    this.router.navigate(['/buyAbonamentConfirmed']);
  }
}
