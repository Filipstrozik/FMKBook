import {Seans} from "./seans.model";
import {Sala} from "./sala.model";
import {Agent} from "./agent.model";

export interface Kino {
  id: number;
  agentidagenta?: Agent;
  adres: string;
  seans?: Set<Seans>;
  salas?: Set<Sala>;
}
