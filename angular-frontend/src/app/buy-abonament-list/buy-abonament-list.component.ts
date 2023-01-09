import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buy-abonament-list',
  templateUrl: './buy-abonament-list.component.html',
  styleUrls: ['./buy-abonament-list.component.css']
})
export class BuyAbonamentListComponent implements OnInit {


  typyAbonamentu: TypAbonamentu[] = [
    { id: 0, time: "6 miesięcy", price: 120},
    { id: 1, time: "3 miesiące", price: 150},
    { id: 2, time: "1 miesiąc", price: 180}
  ];
  constructor() { }

  ngOnInit(): void {
  }
  statusClass = 'not-active';
  selectedType?: TypAbonamentu;
  onSelect(typ: TypAbonamentu): void {
    this.selectedType = typ;
    this.statusClass = 'active';
  }

}

export interface TypAbonamentu {
  id: number;
  time: string;
  price: number;
}
