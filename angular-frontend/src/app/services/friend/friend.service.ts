import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FriendService {
  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/v1/sms';
  }
  sendSms(idUser:number, nr: string):Observable<any>{
    const headers = { 'content-type': 'application/json'}
    let message = 'Zostales polecony przez twojego znajomego. Zaloz konto z tego linku http://localhost:4200/reflink/ i zgarnijcie rabaty'
    const json = `{ "phoneNumber":"${nr}", "message":"${message}"}`;
    return this.http.post(this.url,json,{'headers':headers});

  }
}
