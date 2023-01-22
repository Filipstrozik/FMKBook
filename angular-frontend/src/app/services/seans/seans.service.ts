import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Seans} from "../../seans.model";

@Injectable({
  providedIn: 'root'
})
export class SeansService {

  private apiURL = 'http://localhost:8080/seans';

  constructor(private http: HttpClient) { }

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
