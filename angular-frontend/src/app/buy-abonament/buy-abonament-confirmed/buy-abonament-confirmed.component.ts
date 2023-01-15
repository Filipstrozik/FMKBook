import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-buy-abonament-confirmed',
  templateUrl: './buy-abonament-confirmed.component.html',
  styleUrls: ['./buy-abonament-confirmed.component.css']
})
export class BuyAbonamentConfirmedComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }


  confirm() {
    this.router.navigate(['']);
  }
}
