import {Kino} from "./kino.model";
import {Miejsce} from "./miejsce.model";

export interface Sala {
  id: number;
  kinoidkina?: Kino;
  iloscmiejsc?: number;
  miejsces?: Set<Miejsce>;
}
