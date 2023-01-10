import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-invite-inform',
  templateUrl: './invite-inform.component.html',
  styleUrls: ['./invite-inform.component.css']
})
export class InviteInformComponent implements OnInit {

  constructor(private router: Router) { }
  nr = ''
  info = 'Użytkownik o numerze ' +this.nr +' opłacił pierwsze zamówienie. Dodano do twojego profilu kod rabatowy -50%'
  info2 = 'Pomyślnie utworzono konto z linku polecającego. Dodano do twojego profilu kod rabatowy -50%'
  info3 = 'Niestety użytkownik o numerze  ' +this.nr +' nie odpowiedział na twoje zaproszenie'
  ngOnInit(): void {
  }
  back() {
    this.router.navigate(['']);
  }
}
