import {Seans} from "./seans.model";
import {Bilet} from "./bilet.model";
import {Uzytkownik} from "./uzytkownik.model";
import {Rabat} from "./rabat.model";

export interface Rezerwacja {
  id: number;
  uzytkownikiduzytkownika: Uzytkownik;
  rabatkodrabatowy: Rabat;
  cenarezerwacji: number;
  seansidseansu: Seans;
  // sposobplatnoscinazwametody: Sposobplatnosci;
  bilets?: Bilet[];
}
