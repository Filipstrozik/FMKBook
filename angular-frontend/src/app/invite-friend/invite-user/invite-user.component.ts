import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-invite-user',
  templateUrl: './invite-user.component.html',
  styleUrls: ['./invite-user.component.css']
})
export class InviteUserComponent implements OnInit {

  constructor(private router: Router) { }
  nr = ''
  ngOnInit(): void {
  }
  add() {
    this.router.navigate(['successSent']);
  }

  cancel() {
    this.router.navigate(['']);
  }
}
