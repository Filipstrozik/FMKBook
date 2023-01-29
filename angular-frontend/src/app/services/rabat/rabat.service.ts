import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class RabatService {
  constructor(private http: HttpClient,private ip: IpServiceService) { }

  // private baseUrl = 'http://localhost:8080/';

  private url = `http://${this.ip.ip}:8080/rabat`;


  updateRabat(idUser:number, idRabatu: string):Observable<any>{
    const params = new HttpParams()
      .set('idUser', idUser)
      .set('idRabatu', idRabatu);

    return this.http.put(`${this.url}?idUser=${idUser}&idRabatu=${idRabatu}`,{params});

  }
  sentPost(idUser:number, discount: number):Observable<any>{
    const params = new HttpParams()
      .set('idUser', +idUser)
      .set('discount', discount);

    console.log("wysylam dla"+idUser)
    return this.http.post(`${this.url}?idUser=${idUser}&discount=${discount}`,{params});

  }
}
