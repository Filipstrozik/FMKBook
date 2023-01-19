import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NotificationService} from "../../services/notification/notification.service";
import {UserIdService} from "../../services/userId/user-id.service";

@Component({
  selector: 'app-invite-inform',
  templateUrl: './invite-inform.component.html',
  styleUrls: ['./invite-inform.component.css']
})
export class InviteInformComponent implements OnInit {
  info: string | undefined =''
  constructor(private router: Router, private notificationService: NotificationService,private userId: UserIdService) { }

  ngOnInit(): void {
    //this.notificationService.setNotification(1,'123');
    this.info = this.notificationService.getNotification(this.userId.getNumber())
    console.log(this.userId.getNumber())
    console.log(this.info)

  }
  back() {
    this.router.navigate(['']);
  }
}
