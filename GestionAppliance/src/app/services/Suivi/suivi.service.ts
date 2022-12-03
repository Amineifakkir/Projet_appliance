import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pov } from 'src/app/Model/pov';
import { Suivi } from 'src/app/Model/suivi';
import { TypePrestation } from 'src/app/Model/type-prestation';

@Injectable({
  providedIn: 'root'
})
export class SuiviService {
  constructor(private http:HttpClient) { }
  persist(suivi : Suivi) {
    console.log(suivi)
    return this.http.post<Suivi>("http://localhost:8080/Suivi/add",suivi);
   }
    

    findAll(page : number, size : number){
      return this.http.get<any>("http://localhost:8080/Suivi/Find?page="+page+"&size="+size);
    }

    findAllPov(){
      return this.http.get<Pov[]>("http://localhost:8080/Pov/Findtp");
    }
    findAllPrestation(){
    
      return this.http.get<TypePrestation[]>("http://localhost:8080/TypePrestation/Findtp");
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Suivi/Delete/'+id);
    }
    
    update(suivi: any){
      console.log(suivi)
      return this.http.put<Suivi>('http://localhost:8080/Suivi/Update/'+suivi.idSuivi,suivi);
  
    }
}
