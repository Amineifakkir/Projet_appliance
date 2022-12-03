import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from 'src/app/Model/client';
import { Contact } from 'src/app/Model/contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http:HttpClient) { }
  persist(contact : Contact) {
    console.log(contact);
    return this.http.post<Contact>("http://localhost:8080/Contact/add",contact);
   }
    findAll(page : number, size : number){
      
      return this.http.get<any>("http://localhost:8080/Contact/Find?page="+page+"&size="+size);
    }
    findAllContact(){
      return this.http.get<Client[]>("http://localhost:8080/Client/Findtp");
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Contact/Delete/'+id);
    }
    
    update(contact: any){
      return this.http.put<Contact>('http://localhost:8080/Contact/Update/'+contact.idContact,contact);
  
    }
}
