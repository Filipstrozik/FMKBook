import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Sala} from "../../sala.model";
import {IpServiceService} from "../../ip-service.service";

@Injectable({
  providedIn: 'root'
})
export class SalaService {



  constructor(private http: HttpClient,
              private ip: IpServiceService) { }

  private baseUrl = `http://${this.ip.ip}:8080/sala`;


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
