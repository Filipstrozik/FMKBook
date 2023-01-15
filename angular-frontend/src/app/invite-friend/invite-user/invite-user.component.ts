import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RabatService} from "../../services/rabat/rabat.service";
import {FriendService} from "../../services/friend/friend.service";

@Component({
  selector: 'app-invite-user',
  templateUrl: './invite-user.component.html',
  styleUrls: ['./invite-user.component.css']
})
export class InviteUserComponent implements OnInit {

  constructor(private router: Router, private friendService: FriendService) { }
  nr = ''
  idUser = 1;
  ngOnInit(): void {
  }
  add() {
    console.log(this.nr+ ' '+ this.idUser)
    this.friendService.sendSms(this.idUser, this.nr).subscribe(data => {

      this.router.navigate(['successSent']);
    });

  }

  cancel() {
    this.router.navigate(['']);
  }
}
