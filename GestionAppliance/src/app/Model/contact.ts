import { Client } from "./client";

export interface Contact {
    idContact:number,
    Nom?:String,
    Prenom?:String,
    Telephone?:String,
    fonction?:String,
    idClient:Client,
    Email?:String
}
