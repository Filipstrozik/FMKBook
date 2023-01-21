import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Sala} from "../../sala.model";

@Injectable({
  providedIn: 'root'
})
export class SalaService {

  private baseUrl = 'http://localhost:8080/sala';

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Sala[]>(`${this.baseUrl}`);
  }

  getById(id: number) {
    return this.http.get<Sala>(`${this.baseUrl}/${id}`);
  }

  create(sala: Sala) {
    return this.http.post(`${this.baseUrl}`, sala);
  }

  update(sala: Sala) {
    return this.http.put(`${this.baseUrl}/${sala.id}`, sala);
  }

  delete(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
