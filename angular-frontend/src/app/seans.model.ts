import {Film} from "./film.model";
import {Kino} from "./kino.model";
import {Time} from "@angular/common";

export interface Seans {
  id: number;
  czas: Date;
  data: Date;
  kinoidkina?: Kino;
  filmidfilmu?: Film;
  cenaseansu: number;
}
