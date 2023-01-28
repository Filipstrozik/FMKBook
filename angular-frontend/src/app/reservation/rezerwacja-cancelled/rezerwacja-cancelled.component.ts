import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-rezerwacja-cancelled',
  templateUrl: './rezerwacja-cancelled.component.html',
  styleUrls: ['./rezerwacja-cancelled.component.css']
})
export class RezerwacjaCancelledComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  confirm() {
    this.router.navigate(['']);
  }

}
