import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypAbonamentu} from "../../typ-abonamentu.model";
import {Rezerwacja} from "../../rezerwacja.model";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient,private ip: IpServiceService) { }

  // private baseUrl = 'http://localhost:8080/';

  private baseUrl = `http://${this.ip.ip}:8080/`;

  getReservationsByDate(startDate: Date, endDate: Date) {
    let params = new HttpParams().set("startDate", new Date(startDate).toLocaleDateString()).set("endDate", new Date(endDate).toLocaleDateString());
    return this.http.get<Rezerwacja[]>(this.baseUrl + 'reservations/byDate', {params});
  }
  createReservation(reservation: Rezerwacja) {
    return this.http.post(`${this.baseUrl}reservations`, reservation);
  }

  createReservationForUserAndSeans(userid: number, seansid: number) {
    const emptyRezerwacja: Rezerwacja = Object.create(null);
    const params = new HttpParams().set('user', userid).set('seans', seansid);
    return this.http.post<Rezerwacja>(this.baseUrl + 'reservations/param', emptyRezerwacja, {params});
  }

  getReservations() {
    return this.http.get(this.baseUrl + 'reservations');
  }

  getReservationById(id: number) {
    return this.http.get<Rezerwacja>(this.baseUrl + 'reservations/' + id);
  }

  updateReservation(id: number, reservation: Rezerwacja) {
    return this.http.put(this.baseUrl + 'reservations/' + id, reservation);
  }

  updateReservationCena(id: number, cena: number) {
    const params = new HttpParams().set('cena', cena);
    return this.http.put<Rezerwacja>(this.baseUrl + 'reservations/cena/' + id, {}, {params});
  }

  deleteReservation(id: number) {
    return this.http.delete(this.baseUrl + 'reservations/' + id);
  }
}
