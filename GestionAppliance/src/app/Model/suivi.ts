import { Pov } from "./pov";
import { TypePrestation } from "./type-prestation";

export interface Suivi {
    idSuivi:number;
    offreCommercial?: boolean;
    montant?: number;
    compteRendu?:String;
    typePres: TypePrestation;
    povSuivi:Pov
}
