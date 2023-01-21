import {Sala} from "./sala.model";
import {Bilet} from "./bilet.model";

export interface Miejsce {
  id: number;
  rzad: string;
  kolumna: string;
  salaidsali?: Sala;
  // typmiejscanazwatypumiejsca?: Typmiejsca;
  bilets?: Set<Bilet>;
}
