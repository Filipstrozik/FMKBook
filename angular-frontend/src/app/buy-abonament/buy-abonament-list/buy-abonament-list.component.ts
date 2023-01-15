import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {TypAbonamentuService} from "../../services/typ-abonamentu/typ-abonamentu.service";
import {TypAbonamentu} from "../../typ-abonamentu.model";

@Component({
  selector: 'app-buy-abonament-list',
  templateUrl: './buy-abonament-list.component.html',
  styleUrls: ['./buy-abonament-list.component.css']
})
export class BuyAbonamentListComponent implements OnInit {


  typyAbonamentu: TypAbonamentu[] = [
    // { id: 10, opis: "6 miesięcy", cena: 120},
    // { id: 11, opis: "3 miesiące", cena: 150},
    // { id: 12, opis: "1 miesiąc", cena: 180}
  ];
  constructor(private router: Router, private typAbonamentuService: TypAbonamentuService) { }

  ngOnInit(): void {
    this.getAllTypAbonamentu();
  }

  private getAllTypAbonamentu() {
    this.typAbonamentuService.getTypAbonamentuList().subscribe( data => {
        this.typyAbonamentu = data
      }
    )
  }

  statusClass = 'not-active';
  selectedType?: TypAbonamentu;
  onSelect(typ: TypAbonamentu): void {
    this.selectedType = typ;
    this.statusClass = 'active';
  }

  navigateToDetails() {
    this.router.navigate(['abonamentDetails', this.selectedType?.id]);
  }

  cancel() {
    this.router.navigate(['/buyAbonamentCancelled']);
  }

}
