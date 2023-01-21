import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class KinoService {
  private baseUrl = 'http://localhost:8080/kino';

  constructor(private http: HttpClient) { }

  getKino(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createKino(kino: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, kino);
  }

  updateKino(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteKino(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getKinosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
