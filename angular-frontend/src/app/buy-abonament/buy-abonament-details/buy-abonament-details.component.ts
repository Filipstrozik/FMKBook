import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TypAbonamentu} from "../buy-abonament-list/buy-abonament-list.component";

@Component({
  selector: 'app-buy-abonament-details',
  templateUrl: './buy-abonament-details.component.html',
  styleUrls: ['./buy-abonament-details.component.css']
})
export class BuyAbonamentDetailsComponent implements OnInit {
  typyAbonamentu: TypAbonamentu[] = [
    { id: 10, time: "6 miesięcy", price: 120},
    { id: 11, time: "3 miesiące", price: 150},
    { id: 12, time: "1 miesiąc", price: 180}
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
