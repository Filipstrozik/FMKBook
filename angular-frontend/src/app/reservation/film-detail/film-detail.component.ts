import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FilmService} from "../../services/film/film.service";
import {Film} from "../../film.model";
import {Seans} from "../../seans.model";
import {SeansService} from "../../services/seans/seans.service";

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrls: ['./film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {
  filmId: number;
  film!: Film;
  seansList!: Seans[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private filmService: FilmService,
              private seansService: SeansService) {
    this.filmId = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.filmService.getFilm(this.filmId).subscribe(data => {
      this.film = data;
    });
    this.seansService.getSeansByFilmId(this.filmId).subscribe( data => {
      this.seansList = data;
    })

  }

  ngOnInit() {
  }

  onSelect(index: number) {
    this.router.navigate(['seansMiejsca', index]);
  }
}
