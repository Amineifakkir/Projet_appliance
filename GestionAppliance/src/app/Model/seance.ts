import { Pov } from "./pov";
export interface Seance {
    idSeance:number;
    dateSceance?: Date;
    resumer?: String;
    povSeance: Pov;
    participant?: String;
}
