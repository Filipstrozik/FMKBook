import {Kino} from "./kino.model";

export interface Agent {
  id: number;
  tel: string;
  haslo: string;
  email?: string;
  kino?: Kino;
}
