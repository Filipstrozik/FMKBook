import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypAbonamentu} from "../../typ-abonamentu.model";
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
    return this.http.get(this.baseUrl + 'reservations');
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
