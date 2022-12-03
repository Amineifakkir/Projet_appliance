import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pov } from 'src/app/Model/pov';
import { Seance } from 'src/app/Model/seance';

@Injectable({
  providedIn: 'root'
})
export class SeanceService {
  constructor(private http:HttpClient) { }
  persist(seance : Seance) {
    return this.http.post<Seance>("http://localhost:8080/Seance/add",seance);
   }
    
    findAll(page : number, size : number){
      return this.http.get<any>("http://localhost:8080/Seance/Find?page="+page+"&size="+size);
    }
    
    findAllPov(){
      return this.http.get<Pov[]>("http://localhost:8080/Pov/Findtp");
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Seance/Delete/'+id);
    }
    
    update(seance: Seance){
      return this.http.put<Seance>('http://localhost:8080/Seance/Update/'+seance.idSeance,seance);
  
    }
}
