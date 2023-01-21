import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FilmService} from "../../services/film/film.service";
import {Film} from "../../film.model";

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrls: ['./film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {

  film!: Film;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private filmService: FilmService) {
    let id: number = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.filmService.getFilm(id).subscribe(data => {
      this.film = data;
    });

  }

  ngOnInit(): void {

  }

}
