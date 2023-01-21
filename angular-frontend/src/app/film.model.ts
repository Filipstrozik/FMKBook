import {Seans} from "./seans.model";

export interface Film{
  id: number;
  tytul: string;
  gatunek: string;
  dlugosc: number;
  seans?: Set<Seans>;
}
