import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-buy-abonament-cancelled',
  templateUrl: './buy-abonament-cancelled.component.html',
  styleUrls: ['./buy-abonament-cancelled.component.css']
})
export class BuyAbonamentCancelledComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  confirm() {
    this.router.navigate(['']);
  }

}
