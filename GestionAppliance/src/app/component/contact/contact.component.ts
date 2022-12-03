import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Client } from 'src/app/Model/client';
import { Contact } from 'src/app/Model/contact';
import { ContactService } from 'src/app/services/Contact/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  showForm=false;
  editForm = false;

  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0; 

  clients :Client[]=[];

  
  
  // types: Type[]=[];
contacts :Contact[]=[];

  
Mycontact :Contact={
    idContact:0,
      
    idClient:{
        idClt:0,
    },
      Email:""
}
  constructor(private contactService: ContactService) { }

  ngOnInit(): void {
    this.getClient(0, this.itemsPerPage);
    this.getContact();
  }

getContact(){
  this.contactService.findAllContact().subscribe(clients =>
    this.clients=clients)
}

getClient(page: number, size: number){
  this.contactService.findAll(page,size).subscribe(contacts =>{
   
    this.contacts = contacts.pages;
    this.totalItems = contacts.totalItems;
    console.log(contacts);

})
}
pageChanged($event: number) {
  this.currentPage = $event;
  this.getClient(this.currentPage - 1, this.itemsPerPage)
}

deleteClient(id:number){
  this.contactService.delete(id)
  .subscribe(() => {this.contacts=this.contacts.filter(contact=>contact.idContact != id)})
}
persistClient(f:any){
  // f.value as Contact
this.contactService.persist(f.value).subscribe((contact: Contact)=>this.contacts =[contact , ...this.contacts]);


}
editClient(Client:any){
this.Mycontact=  Client;
this.editForm=true;
}
resetClient(){
this.Mycontact={
  idContact:0,
      Nom:"",
      Prenom:"",
      Telephone:"",
      fonction:"",
      idClient:{
        idClt:0,
    
      },
      Email:""
}
}
updateClient(){
this.contactService.update(this.Mycontact).subscribe(client=>{
this.resetClient();
this.editForm=false;

})
}

}
