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


  createReservation(reservation: Rezerwacja) {
    return this.http.post(this.baseUrl + 'rezerwacja', reservation);
  }

  createReservationForUserAndSeans(userid: number, seansid: number) {
    const emptyRezerwacja: Rezerwacja = Object.create(null);
    const params = new HttpParams().set('user', userid).set('seans', seansid);
    return this.http.post<Rezerwacja>(this.baseUrl + 'rezerwacja/param', emptyRezerwacja, {params});
  }

  getReservations() {
    return this.http.get(this.baseUrl + 'rezerwacja');
  }

  getReservationById(id: number) {
    return this.http.get<Rezerwacja>(this.baseUrl + 'rezerwacja/' + id);
  }

  updateReservation(id: number, reservation: Rezerwacja) {
    return this.http.put(this.baseUrl + 'rezerwacja/' + id, reservation);
  }

  updateReservationCena(id: number, cena: number) {
    const params = new HttpParams().set('cena', cena);
    return this.http.put<Rezerwacja>(this.baseUrl + 'rezerwacja/cena/' + id, {}, {params});
  }

  deleteReservation(id: number) {
    return this.http.delete(this.baseUrl + 'rezerwacja/' + id);
  }
}
