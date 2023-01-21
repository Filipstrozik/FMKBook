import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RabatService {
  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/rabat';
  }
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
