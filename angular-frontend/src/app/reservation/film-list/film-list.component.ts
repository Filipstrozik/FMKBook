import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FilmService} from "../../services/film/film.service";
import {Film} from "../../film.model";

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css']
})
export class FilmListComponent implements OnInit {

  films: Film[] = [];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private filmService: FilmService) { }

  ngOnInit(): void {
    this.filmService.getFilms().subscribe(data => {
      this.films = data;
    })
  }

  onSelect(index: number) {
    const foundFilm = this.films.find(f => f.id === index);
    if(foundFilm){
      this.filmService.setSelectedFilm(foundFilm);
    }
    this.router.navigate(['reservationFilms', index]);
  }

}
