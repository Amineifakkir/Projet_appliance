import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/Model/client';
import { ClientService } from 'src/app/services/Client/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;
  // types: Type[]=[];
clients :Client[]=[];

  
    Myclient :Client={
      idClt:0,
 
}
  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.getClient(0, this.itemsPerPage);
  }



getClient(page: number, size: number){
  this.clientService.findAll(page,size).subscribe(clients =>{
   
    this.clients = clients.pages;
    this.totalItems = clients.totalItems;
    console.log(clients);
  } )

}
pageChanged($event: number) {
  this.currentPage = $event;
  this.getClient(this.currentPage - 1, this.itemsPerPage)
}

deleteClient(id:number){
  this.clientService.delete(id)
  .subscribe(() => {this.clients=this.clients.filter(client=>client.idClt != id)})
}
persistClient(f:any){
  
  f.value as Client;
this.clientService.persist(f.value).subscribe((client)=>this.clients =[client , ...this.clients]);
this.resetClient();

}
editClient(client:any){
this.Myclient=  client;
this.editForm=true;
}
resetClient(){
this.Myclient={
  idClt:0,
  
}
}
updateClient(){
this.clientService.update(this.Myclient).subscribe(client=>{
this.resetClient();
this.editForm=false;

}
)
}


}
