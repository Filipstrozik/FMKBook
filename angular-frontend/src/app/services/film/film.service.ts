import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Film} from "../../film.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  selectedFilm: Film;
  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080/film';

  getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>(`${this.baseUrl}`);
  }

  getFilm(id: number): Observable<Film> {
    return this.http.get<Film>(`${this.baseUrl}/${id}`);
  }

  createFilm(film: Film) {
    return this.http.post(`${this.baseUrl}`, film);
  }

  updateFilm(id: number, film: Film) {
    return this.http.put(`${this.baseUrl}/${id}`, film);
  }

  deleteFilm(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getSelectedFilm(){
    return this.selectedFilm;
  }

  setSelectedFilm(film: Film){
    this.selectedFilm = film;
  }
}
