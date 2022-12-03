import { Appliance } from "./appliance";
import { Client } from "./client";
export interface Pov {

  idPov: number;
  date_Debut?: Date;
  date_Fin?: Date;
  description?: string;
  compteManager?: string;
  ingenieur_CyberSecurite?: string;
  analyse_CyberSecurite?: string;
  libelle_Pov?: string;
  idClient: Client;
  idAppliance: Appliance;
}


