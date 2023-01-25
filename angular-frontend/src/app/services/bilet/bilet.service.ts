import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rezerwacja} from "../../rezerwacja.model";
import {Bilet} from "../../bilet.model";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class BiletService {


  private baseUrl = `http://${this.ip.ip}:8080/bilet`;

  constructor(private http: HttpClient, private ip: IpServiceService) { }

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

  setBiletTyp(id: number, typ: string): Observable<Bilet> {
    const emptyBilet: Bilet = Object.create(null);
    const params = new HttpParams().set('typ', typ);
    return this.http.put<Bilet>(`${this.baseUrl}/typ/${id}`, {}, {params});
  }

  setBiletMiejsceTyp(id: number, typ: string): Observable<Bilet> {
    const emptyBilet: Bilet = Object.create(null);
    const params = new HttpParams().set('typ', typ);
    return this.http.put<Bilet>(`${this.baseUrl}/miejsce/${id}`, {} ,{params});
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
