import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TypAbonamentu} from "../../typ-abonamentu.model";
import {TypAbonamentuService} from "../../services/typ-abonamentu/typ-abonamentu.service";

@Component({
  selector: 'app-buy-abonament-details',
  templateUrl: './buy-abonament-details.component.html',
  styleUrls: ['./buy-abonament-details.component.css']
})
export class BuyAbonamentDetailsComponent implements OnInit {
  typyAbonamentu: TypAbonamentu[] = [
  ];


  selectedType!: TypAbonamentu;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private typAbonamentService: TypAbonamentuService) {
    console.log(this.route.snapshot.paramMap.get('id'));
    let id: number = parseInt(<string>this.route.snapshot.paramMap.get('id'));

      // this.selectedType = this.typyAbonamentu.find(t => t.id == id)!
      this.typAbonamentService.getTypAbonamentu(id).subscribe(data => {
        this.selectedType = data;
      });

  }

  ngOnInit(): void {

  }


  cancel() {
    this.router.navigate(['/buyAbonamentCancelled']);
  }

  confirm() {
    this.router.navigate(['/buyAbonamentConfirmed', {idUser: 1, idTypAbonamentu: this.selectedType.id}]);
  }
}
