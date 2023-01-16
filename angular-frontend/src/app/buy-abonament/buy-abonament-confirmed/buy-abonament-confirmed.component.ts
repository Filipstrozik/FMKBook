import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbonamentService} from "../../services/abonament/abonament.service";

@Component({
  selector: 'app-buy-abonament-confirmed',
  templateUrl: './buy-abonament-confirmed.component.html',
  styleUrls: ['./buy-abonament-confirmed.component.css']
})
export class BuyAbonamentConfirmedComponent implements OnInit {

  private idUser: number;
  private idTypAbonamentu: number;
  constructor(private router: Router,
              private route: ActivatedRoute,
              private abonamentService: AbonamentService) {
    console.log('user')
    console.log(this.route.snapshot.paramMap.get('idUser'));
    this.idUser = parseInt(<string>this.route.snapshot.paramMap.get('idUser'));
    console.log('typabonamentu')
    console.log(this.route.snapshot.paramMap.get('idTypAbonamentu'));
    this.idTypAbonamentu = parseInt(<string>this.route.snapshot.paramMap.get('idTypAbonamentu'));
  }

  ngOnInit(): void {
    this.abonamentService.addNewAbonament(this.idUser, this.idTypAbonamentu).subscribe();
  }



  confirm() {
    this.router.navigate(['']);
  }
}
