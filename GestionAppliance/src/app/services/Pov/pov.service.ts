import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appliance } from 'src/app/Model/appliance';
import { Client } from 'src/app/Model/client';
import { Pov } from 'src/app/Model/pov';

@Injectable({
  providedIn: 'root'
})
export class PovService {

  constructor(private http:HttpClient) { }
  persist(pov : Pov) {
    console.log(pov)
    return this.http.post<Pov>("http://localhost:8080/Pov/add",pov);
   }
    
    findAll(page : number, size : number){
      return this.http.get<any>("http://localhost:8080/Pov/Find?page="+page+"&size="+size);
    }
    findAllClient(){
      return this.http.get<Client[]>("http://localhost:8080/Client/Findtp");
    }
    findAllPov(){
      return this.http.get<Appliance[]>("http://localhost:8080/Appliance/Findtp");
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Pov/Delete/'+id);
    }
    
    update(pov: any){
      console.log(pov);
      return this.http.put<Pov>('http://localhost:8080/Pov/Update/'+pov.idPov,pov);
  
    }
}
