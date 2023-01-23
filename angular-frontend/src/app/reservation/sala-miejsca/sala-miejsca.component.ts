import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {MiejsceService} from "../../services/miejsce/miejsce.service";
import {SeansService} from "../../services/seans/seans.service";
import {Miejsce} from "../../miejsce.model";
import {ActivatedRoute} from "@angular/router";
import {UserIdService} from "../../services/userId/user-id.service";
import {Rezerwacja} from "../../rezerwacja.model";
import {ReservationService} from "../../services/reservation/reservation.service";
import {Film} from "../../film.model";
import {FilmService} from "../../services/film/film.service";
import {BiletService} from "../../services/bilet/bilet.service";
import {Bilet} from "../../bilet.model";

@Component({
  selector: 'app-sala-miejsca',
  templateUrl: './sala-miejsca.component.html',
  styleUrls: ['./sala-miejsca.component.css']
})
export class SalaMiejscaComponent implements OnInit {
  seansId: number;
  miejscaList!: Miejsce[];
  selectedMiejsca!: Miejsce[];
  rezerwacja!: Rezerwacja;
  rows!: Miejsce[][];
  displayMap = true;
  film!: Film;
  bilety: Bilet[] = [];
  sumaRezerwacji: number;


  constructor(private miejsceService: MiejsceService,
              private seansService: SeansService,
              private route: ActivatedRoute,
              private userService: UserIdService,
              private rezerwacjaService: ReservationService,
              private filmService: FilmService,
              private biletService: BiletService) { }

  ngOnInit(): void {
    this.seansId = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.film = this.filmService.getSelectedFilm();
    console.log(this.film);
    this.miejsceService.getMiejscaBySeans(this.seansId).subscribe( data => {
      this.miejscaList = data;
      this.rows = this.miejscaList.reduce((acc, curr) => {
        acc[curr.rzad] = acc[curr.rzad] || [];
        acc[curr.rzad].push(curr);
        return acc;
      }, []);
      console.log(this.rows);
    })

    this.rezerwacjaService.createReservationForUserAndSeans(this.userService.getNumber(), this.seansId).subscribe(
      data => {
        this.rezerwacja = data;
      }
    )
    this.selectedMiejsca = [];

  }

  onSelectSeat(seatId: number){
    const selectedSeat: Miejsce = this.miejscaList.find( m => m.id === seatId);
    if (selectedSeat){
      const index = this.selectedMiejsca.indexOf(selectedSeat);
      if (index === -1) {
        this.selectedMiejsca.push(selectedSeat);
      } else {
        this.selectedMiejsca.splice(index, 1);
      }
    }
    console.log(this.selectedMiejsca);
  }

  toggleColor(event) {
    event.target.classList.toggle("clicked");
  }

  confirm() {
    for (const miejsce of this.selectedMiejsca) {
      this.biletService.createBiletForMiejsceAndRezerwacja(miejsce.id, this.rezerwacja.id).subscribe(
        data => {
          this.bilety.push(data);
          this.sumaRezerwacji += data.cenabiletu;
        }
      );
    }
    this.rezerwacjaService.getReservationById(this.rezerwacja.id).subscribe(
      data => {
        this.rezerwacja = data;
        this.sumaRezerwacji = this.rezerwacja.cenarezerwacji;
      }
    );
    console.log(this.sumaRezerwacji);
    this.displayMap = false;


  }

  onChange(value){
    console.log(value);
  }

  logSelectedOptions(typMiejsca: string, typBiletu: string) {
    console.log(`Selected type of seat: ${typMiejsca}`);
    console.log(`Selected type of ticket: ${typBiletu}`);
  }

  doSomething() {
    console.log('change!');
  }

}
