import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Rezerwacja} from "../../rezerwacja.model";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080/';

  createReservation(reservation: Rezerwacja) {
    return this.http.post(this.baseUrl + 'reservations', reservation);
  }

  getReservations() {
    return this.http.get<Rezerwacja[]>(this.baseUrl + 'reservations');
  }

  getReservationsByDate(startDate: Date, endDate: Date) {
    let params = new HttpParams().set("startDate", new Date(startDate).toLocaleDateString()).set("endDate", new Date(endDate).toLocaleDateString());
    return this.http.get<Rezerwacja[]>(this.baseUrl + 'reservations/byDate', {params});
  }

  getReservationById(id: number) {
    return this.http.get(this.baseUrl + 'reservations/' + id);
  }

  updateReservation(id: number, reservation: Rezerwacja) {
    return this.http.put(this.baseUrl + 'reservations/' + id, reservation);
  }

  deleteReservation(id: number) {
    return this.http.delete(this.baseUrl + 'reservations/' + id);
  }
}
