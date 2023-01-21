import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {NotificationService} from "../../services/notification/notification.service";
import {UserIdService} from "../../services/userId/user-id.service";
import {HttpClient, HttpParams} from "@angular/common/http";
import {RabatService} from "../../services/rabat/rabat.service";

@Component({
  selector: 'app-reflink',
  templateUrl: './reflink.component.html',
  styleUrls: ['./reflink.component.css']
})
export class ReflinkComponent implements OnInit {

  phoneNumber: string = '';
  id: number = 0;


  constructor(private rabatService: RabatService, private http: HttpClient, private route: ActivatedRoute, private router: Router, private notificationService: NotificationService, private userIdService: UserIdService) {
  }

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
          console.log(params); // { orderby: "price" }
          this.phoneNumber = params['pN'];
          this.id = params['id'];
          console.log(this.id)
          console.log(this.phoneNumber); // price
        }
      );
  }

  add() {

    this.rabatService.sentPost(this.id, 50.0).subscribe(data => {
      this.notificationService.setNotification(+this.id, 1, this.phoneNumber)
      console.log(this.notificationService.getNotification(this.id))
      let newId = this.phoneNumber.substring(4,9)
      this.userIdService.setNumber(+newId)
      console.log(this.userIdService.getNumber())
      this.rabatService.sentPost(this.userIdService.getNumber(), 50.0).subscribe(data => {
        this.notificationService.setNotification(this.userIdService.getNumber(), 2, '')
        this.router.navigate(['info']);
        console.log(this.userIdService.getNumber())
      });
    });

  }

  cancel() {
    this.router.navigate(['']);
  }

}
