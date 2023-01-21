import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

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

  updateBilet(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteBilet(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getBiletsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
