import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NotificationService} from "../../services/notification/notification.service";

@Component({
  selector: 'app-invite-inform',
  templateUrl: './invite-inform.component.html',
  styleUrls: ['./invite-inform.component.css']
})
export class InviteInformComponent implements OnInit {
  info =''
  constructor(private router: Router, private notificationService: NotificationService) { }

  ngOnInit(): void {
    //this.notificationService.setNotification(1,'123');
    this.info = this.notificationService.getNotification()

  }
  back() {
    this.router.navigate(['']);
  }
}
