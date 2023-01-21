import {Injectable} from '@angular/core';
import {map} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  map = new Map<number, string>()

  constructor() {
  }

  setNotification(id: number,infoNr: number, nr: string) {
    let info =''
    if (infoNr == 1) {
      info = 'Użytkownik o numerze ' + nr + ' założył konto. Dodano do twojego profilu kod rabatowy'
    }
    if (infoNr == 2) {
      info = 'Pomyślnie utworzono konto z linku polecającego. Dodano do twojego profilu kod rabatowy'
    }
    if (infoNr == 3) {
      info = 'Niestety użytkownik o numerze  ' + nr + ' nie odpowiedział na twoje zaproszenie'
    }
    this.map.set(id, info);
  }

  getNotification(id:number): string | undefined {
    console.log(this.map)
    return this.map.get(id)
  }

}
