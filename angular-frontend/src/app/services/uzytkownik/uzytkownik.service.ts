import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Uzytkownik} from "../../uzytkownik.model";

@Injectable({
  providedIn: 'root'
})
export class UzytkownikService {

  private baseUrl = 'http://localhost:8080/uzytkownik';

  constructor(private http: HttpClient) { }

  getUzytkownik(id: number) {
    return this.http.get<Uzytkownik>(`${this.baseUrl}/${id}`);
  }

  createUzytkownik(uzytkownik: Object) {
    return this.http.post(`${this.baseUrl}`, uzytkownik);
  }

  updateUzytkownik(id: number, value: any) {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUzytkownik(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getUzytkownikList() {
    return this.http.get<Uzytkownik[]>(`${this.baseUrl}`);
  }
}
