import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  discountCode() {
    this.router.navigate(['addCode']);
  }

  inviteFriend() {
    this.router.navigate(['inviteUser']);
  }

  info() {
    this.router.navigate(['info']);
  }
}
