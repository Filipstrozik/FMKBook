import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buy-abonament-list',
  templateUrl: './buy-abonament-list.component.html',
  styleUrls: ['./buy-abonament-list.component.css']
})
export class BuyAbonamentListComponent implements OnInit {


  typyAbonamentu: TypAbonamentu[] = [
    { id: 0, time: "6mies", price: 120},
    { id: 1, time: "3mies", price: 150}
  ];
  constructor() { }

  ngOnInit(): void {
  }

}

export interface TypAbonamentu {
  id: number;
  time: string;
  price: number;
}
