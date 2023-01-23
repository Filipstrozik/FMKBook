import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rezerwacja} from "../../rezerwacja.model";
import {Bilet} from "../../bilet.model";

@Injectable({
  providedIn: 'root'
})
export class BiletService {


  private baseUrl = 'http://localhost:8080/bilet';

  constructor(private http: HttpClient) { }

  getBilet(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createBilet(bilet: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, bilet);
  }

  createBiletForMiejsceAndRezerwacja(miejsceId: number, rezerwacjaId: number) {
    const emptyBilet: Bilet = Object.create(null);
    const params = new HttpParams().set('miejsce', miejsceId).set('rezerwacja', rezerwacjaId);
    return this.http.post<Bilet>(`${this.baseUrl}/more`, emptyBilet, {params});
  }

  updateBilet(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteBilet(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getBiletsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getBiletsByRezerwacja(idRezerwacji: number): Observable<Bilet[]> {
    return this.http.get<Bilet[]>(`${this.baseUrl}/rezerwacja/${idRezerwacji}`);
  }
}
