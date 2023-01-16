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

  //delete later
  idUser: number = 1;
  navigateToDetails() {
    this.router.navigate(['abonamentDetails', this.selectedType?.id]);
  }

  cancel() {
    this.router.navigate(['/buyAbonamentCancelled']);
  }

}
