import {Miejsce} from "./miejsce.model";
import {Rezerwacja} from "./rezerwacja.model";

export interface Bilet {
  id: number;
  cenabiletu: number;
  rezerwacjaidrezerwacji?: Rezerwacja;
  miejsceidmiejsca?: Miejsce;
  // typbiletunazwatypubiletu?: Typbiletu;
}
