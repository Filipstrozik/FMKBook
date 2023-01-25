import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class AbonamentService {

  private baseUrl = `http://${this.ip.ip}:8080/abonament`;

  constructor(private http: HttpClient, private ip: IpServiceService) { }

  addNewAbonament(idUser:number, idTypuAbonamentu: number):Observable<any>{
    const params = new HttpParams()
      .set('idUser', idUser)
      .set('idRabatu', idTypuAbonamentu);

    return this.http.put(`${this.baseUrl}?idUser=${idUser}&idRabatu=${idTypuAbonamentu}`,{params});
  }
}
