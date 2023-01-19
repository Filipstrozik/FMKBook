import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AbonamentService {
  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/abonament';
  }

  addNewAbonament(idUser:number, idTypuAbonamentu: number):Observable<any>{
    const params = new HttpParams()
      .set('idUser', idUser)
      .set('idRabatu', idTypuAbonamentu);

    return this.http.put(`${this.url}?idUser=${idUser}&idRabatu=${idTypuAbonamentu}`,{params});
  }
}
