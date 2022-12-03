import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from 'src/app/Model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:HttpClient) { }
  persist(client : Client) {
    return this.http.post<Client>("http://localhost:8080/Client/add",client);
   }
    findAll(page : number, size : number){
      return this.http.get<any>("http://localhost:8080/Client/Find?page="+page+"&size="+size);
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Client/Delete/'+id);
    }
    
    update(client: any){
     
      return this.http.put<Client>('http://localhost:8080/Client/Update/'+client.idClt,client);
  
    }
   
}
