import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypAbonamentu} from "../../typ-abonamentu.model";
import {IpServiceService} from "../../ip-service.service";


@Injectable({
  providedIn: 'root'
})
export class TypAbonamentuService {

  private baseUrl = `http://${this.ip.ip}:8080/typ-abonamentu`;

  constructor(private http: HttpClient, private ip: IpServiceService) { }

  getTypAbonamentuList(): Observable<TypAbonamentu[]> {
    return this.http.get<TypAbonamentu[]>(this.baseUrl);
  }

  getTypAbonamentu(id: number): Observable<TypAbonamentu> {
    return this.http.get<TypAbonamentu>(`${this.baseUrl}/${id}`);
  }
}
