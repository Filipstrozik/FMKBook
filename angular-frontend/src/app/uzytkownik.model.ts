import {Rezerwacja} from "./rezerwacja.model";
import {Rabat} from "./rabat.model";

export interface Uzytkownik {
  id: number;
  tel: string;
  haslo: string;
  email: string;
  rabats: Array<Rabat>;
  rezerwacjas: Array<Rezerwacja>;
}
