import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypAbonamentu} from "../../typ-abonamentu.model";


@Injectable({
  providedIn: 'root'
})
export class TypAbonamentuService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/typ-abonamentu';
  }

  getTypAbonamentuList(): Observable<TypAbonamentu[]> {
    return this.http.get<TypAbonamentu[]>(this.baseUrl);
  }
}
