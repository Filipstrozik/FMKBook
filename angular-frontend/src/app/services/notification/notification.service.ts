import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  nr = '123'
  info = ''

  constructor() {
  }

  setNotification(infoNr: number, nr: string) {
    this.nr = nr
    if (infoNr == 1) {
      this.info = 'Użytkownik o numerze ' + this.nr + ' założył konto. Dodano do twojego profilu kod rabatowy'
    }
    if (infoNr == 2) {
      this.info = 'Pomyślnie utworzono konto z linku polecającego. Dodano do twojego profilu kod rabatowy'
    }
    if (infoNr == 3) {
      this.info = 'Niestety użytkownik o numerze  ' + this.nr + ' nie odpowiedział na twoje zaproszenie'
    }
  }

  getNotification(): string {
    return this.info
  }

}
