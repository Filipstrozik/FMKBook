import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserIdService} from "../userId/user-id.service";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class FriendService {
  // private url: string;
  // constructor(private http: HttpClient, private userId: UserIdService) {
  //   this.url = 'http://localhost:8080/api/v1/sms';
  // }

  constructor(private http: HttpClient,private ip: IpServiceService,  private userId: UserIdService) { }

  // private baseUrl = 'http://localhost:8080/';

  private url = `http://${this.ip.ip}:8080/api/v1/sms`;

  sendSms(idUser:number, nr: string):Observable<any>{
    const headers = { 'content-type': 'application/json'}
    let message = `Zostales polecony przez twojego znajomego. Zaloz konto z tego linku http://${this.ip.ip}:4200/reflink/?pN=${nr}&id=${this.userId.getNumber()} i zgarnijcie rabaty`
    const json = `{ "phoneNumber":"${nr}", "message":"${message}"}`;
    return this.http.post(this.url,json,{'headers':headers});

  }
}
