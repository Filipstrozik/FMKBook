import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserIdService} from "../services/userId/user-id.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router, private userIdService: UserIdService) { }

  ngOnInit(): void {
  }
  discountCode() {
    this.router.navigate(['addCode']);
  }

  user2() {
    this.userIdService.setNumber(2);
    console.log(this.userIdService.getNumber())
  }
  user3() {
    this.userIdService.setNumber(3);
    console.log(this.userIdService.getNumber())
  }
  user4() {
    this.userIdService.setNumber(4);
    console.log(this.userIdService.getNumber())
  }

  inviteFriend() {
    this.router.navigate(['inviteUser']);
  }

  info() {
    this.router.navigate(['info']);
  }
  buyAbonament(){
    this.router.navigate(['abonamentList'])
  }
}
