import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TypePrestation } from 'src/app/Model/type-prestation';

@Injectable({
  providedIn: 'root'
})
export class TypePrestationService {
  constructor(private http:HttpClient) { }
  persist(typePrestation : TypePrestation) {
    return this.http.post<TypePrestation>("http://localhost:8080/TypePrestation/add",typePrestation);
   }
   
    findAll(page : number, size : number){
      return this.http.get<any>("http://localhost:8080/TypePrestation/Find?page="+page+"&size="+size);
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/TypePrestation/Delete/'+id);
    }
    
    update(typePrestation: any){
      
      return this.http.put<TypePrestation>('http://localhost:8080/TypePrestation/Update/'+typePrestation.idTypePres,typePrestation);
  
    }
}
