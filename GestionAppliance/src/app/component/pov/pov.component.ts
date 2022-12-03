import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Appliance } from 'src/app/Model/appliance';
import { Client } from 'src/app/Model/client';
import { Pov } from 'src/app/Model/pov';
import { PovService } from 'src/app/services/Pov/pov.service';

@Component({
  selector: 'app-pov',
  templateUrl: './pov.component.html',
  styleUrls: ['./pov.component.css']
})
export class PovComponent implements OnInit {

  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;

  // types: Type[]=[];
povs :Pov[]=[];
clients :Client[]=[];
appliances: Appliance[]=[];

  
    Mypov :Pov={
      idPov:0,
      idClient:{
        idClt:0,
      },
      idAppliance : {
        idAppliance:0,
        idType:  {idType: 0},
       
      }
}
  constructor(private povService: PovService) { }

  ngOnInit(): void {
    this.getPov(0,this.itemsPerPage);
    this.getAppliance();
    this.getClient();
  }

  getClient(){
    this.povService.findAllClient().subscribe(clients =>{
      this.clients=clients
      console.log(clients);
    } )
  
  }
  getAppliance() {
    this.povService.findAllPov().subscribe(appliances => 
  
      this.appliances = appliances
    )

  }
  pageChanged($event: number) {
    this.currentPage = $event;
    this.getPov(this.currentPage - 1, this.itemsPerPage)
  }

getPov(page: number, size: number){
  this.povService.findAll(page,size).subscribe(povs =>{
   
    this.povs = povs.pages;
    this.totalItems = povs.totalItems;
    console.log(povs);

})

}

deletePov(id:number){
  this.povService.delete(id)
  .subscribe(() => {this.povs=this.povs.filter(pov=>pov.idPov != id)})
}

persistPov(f:any){
f.value as Pov
this.povService.persist(f.value).pipe(take(1)).subscribe((pov)=>this.povs =[pov , ...this.povs]);
this.resetPov();

}

editPov(Pov:any){
this.Mypov=  Pov;
this.editForm=true;
}
resetPov(){
this.Mypov={
  idPov:0,
      idClient:{
        idClt:0,
      },
      idAppliance : {
        idAppliance:0,
            idType:  {
              idType: 0
          },
       
      }
}
}

updatePov(){
this.povService.update(this.Mypov).subscribe(pov=>{
  console.log(this.Mypov)
this.resetPov();
this.editForm=false;

})
}

}
