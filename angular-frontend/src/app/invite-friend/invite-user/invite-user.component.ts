import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RabatService} from "../../services/rabat/rabat.service";
import {FriendService} from "../../services/friend/friend.service";
import {UserIdService} from "../../services/userId/user-id.service";

@Component({
  selector: 'app-invite-user',
  templateUrl: './invite-user.component.html',
  styleUrls: ['./invite-user.component.css']
})
export class InviteUserComponent implements OnInit {

  constructor(private router: Router, private friendService: FriendService,
              private userIdService: UserIdService) { }
  nr = ''
  ngOnInit(): void {
  }
  add() {
    let userId = this.userIdService.getNumber()
    console.log(userId)
    this.friendService.sendSms(userId, this.nr).subscribe(data => {

      this.router.navigate(['successSent']);
    });

  }

  cancel() {
    this.router.navigate(['']);
  }
}
