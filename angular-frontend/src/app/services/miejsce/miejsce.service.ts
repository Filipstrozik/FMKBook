import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Miejsce} from "../../miejsce.model";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class MiejsceService {

  // private baseUrl = 'http://localhost:8080/miejsce';

  constructor(private http: HttpClient, private ip: IpServiceService) { }

  private baseUrl = `http://${this.ip.ip}:8080/miejsce`;

  getMiejsca() {
    return this.http.get<Miejsce[]>(this.baseUrl);
  }

  getMiejsce(id: number) {
    return this.http.get<Miejsce>(`${this.baseUrl}/${id}`);
  }

  getMiejscaBySeans(id: number) {
    return this.http.get<Miejsce[]>(`${this.baseUrl}/seans/${id}`);
  }

  createMiejsce(miejsce: Miejsce) {
    return this.http.post(this.baseUrl, miejsce);
  }

  updateMiejsce(id: number, miejsce: Miejsce) {
    return this.http.put(`${this.baseUrl}/${id}`, miejsce);
  }

  deleteMiejsce(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
