import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-buy-abonament-details',
  templateUrl: './buy-abonament-details.component.html',
  styleUrls: ['./buy-abonament-details.component.css']
})
export class BuyAbonamentDetailsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  back() {
    this.router.navigate(['']);
  }
}
