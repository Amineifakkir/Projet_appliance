import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Type } from 'src/app/Model/type';
@Injectable({
  providedIn: 'root'
})
export class TypeService {
 
  
constructor(private http:HttpClient) { }
persist(type : Type) {
  
  return this.http.post<Type>("http://localhost:8080/Type/add",type);
 }

  findAll(page : number, size : number){
    return this.http.get<any>("http://localhost:8080/Type/Find?page="+page+"&size="+size);
  }

  delete(id:number){
    return this.http.delete('http://localhost:8080/Type/Delete/'+id);
  }
  update(type: any){
    console.log(type)
    return this.http.put<Type>('http://localhost:8080/Type/Update/'+type.idType,type);

  }
}
