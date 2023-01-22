import {Film} from "./film.model";
import {Kino} from "./kino.model";

export interface Seans {
  id: number;
  czas: Date;
  kinoidkina?: Kino;
  filmidfilmu?: Film;
  cenaseansu: number;
}
