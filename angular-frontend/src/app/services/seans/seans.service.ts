import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Seans} from "../../seans.model";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class SeansService {


  constructor(private http: HttpClient,private ip: IpServiceService) { }

  private apiURL = `http://${this.ip.ip}:8080/seans`;


  getSeans(): Observable<Seans[]> {
    return this.http.get<Seans[]>(this.apiURL);
  }

  getSeansById(id: number): Observable<Seans> {
    return this.http.get<Seans>(`${this.apiURL}/${id}`);
  }

  getSeansByFilmId(id: number): Observable<Seans[]> {
    return this.http.get<Seans[]>(`${this.apiURL}/film/${id}`);
  }

  createSeans(seans: Seans): Observable<Seans> {
    return this.http.post<Seans>(this.apiURL, seans);
  }

  updateSeans(id: number, seans: Seans): Observable<Seans> {
    return this.http.put<Seans>(`${this.apiURL}/${id}`, seans);
  }

  deleteSeans(id: number): Observable<Seans> {
    return this.http.delete<Seans>(`${this.apiURL}/${id}`);
  }
}
