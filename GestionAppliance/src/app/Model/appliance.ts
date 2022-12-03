import { Type } from "./type";
export interface Appliance {
    idAppliance:number,
    Libelle?:String,
    idType:Type,
    DBID?:String,
    disponibilitte?:boolean,
    References?:String

}
