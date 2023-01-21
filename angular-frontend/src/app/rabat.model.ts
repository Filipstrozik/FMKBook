import {Uzytkownik} from "./uzytkownik.model";
import {Rezerwacja} from "./rezerwacja.model";

export interface Rabat {
  id: string;
  uzytkownikiduzytkownika: Uzytkownik;
  wysokoscrabatu: number;
  rezerwacjas: Rezerwacja[];
}
