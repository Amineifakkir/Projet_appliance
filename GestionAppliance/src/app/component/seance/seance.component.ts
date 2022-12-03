import { Component, OnInit } from '@angular/core';
import { Pov } from 'src/app/Model/pov';
import { Seance } from 'src/app/Model/seance';
import { SeanceService } from 'src/app/services/Seance/seance.service';

@Component({
  selector: 'app-seance',
  templateUrl: './seance.component.html',
  styleUrls: ['./seance.component.css']
})
export class SeanceComponent implements OnInit {

  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;

  // types: Type[]=[];
seances :Seance[]=[];
povs :Pov[]=[];
  
    Myseance :Seance={
      idSeance:0,
    dateSceance: new Date(2000,11,11, 1,1,1),
    resumer: "",
    povSeance:  {
      idPov:0,
  
    idClient:{
      idClt:0,

    },
    idAppliance : {
      idAppliance:0,
      Libelle:"",
      idType:  {
        
        idType: 0
  
      },
      DBID:"",
      disponibilitte:false,
      References:""
    }
  },
    participant: ""
}
  constructor(private seanceService: SeanceService) { }

  ngOnInit(): void {
    this.getSeance(0,this.itemsPerPage);
    this.getPov();
  }

  getPov(){
    this.seanceService.findAllPov().subscribe(Povs =>{
      this.povs=Povs
  
    } )
  
  }

getSeance(page: number, size: number){
  this.seanceService.findAll(page,size).subscribe(seances =>{
   
    this.seances = seances.pages;
    this.totalItems = seances.totalItems;
    console.log(seances);

})
}
pageChanged($event: number) {
  this.currentPage = $event;
  this.getSeance(this.currentPage - 1, this.itemsPerPage)
}
deleteSeance(id:number){
  this.seanceService.delete(id)
  .subscribe(() => {this.seances=this.seances.filter(seance=>seance.idSeance != id)})
}
persistSeance(f:any){
  f.value as Seance
this.seanceService.persist(f.value).subscribe((seance)=>this.seances =[seance , ...this.seances]);
this.resetSeance();

}
editSeance(Client:any){
this.Myseance=  Client;
this.editForm=true;
}
resetSeance(){
this.Myseance={
  idSeance:0,
  dateSceance: new Date(2000,11,11),
  resumer: "",
  povSeance:  {
    idPov:0,
  
  idClient:{
    idClt:0,

  },
  idAppliance : {
    idAppliance:0,
    Libelle:"",
    idType:  {
   
      idType: 0

    },
    DBID:"",
    disponibilitte:false,
    References:""
  }},
  participant: ""
}
}
updateSeance(){
this.seanceService.update(this.Myseance).subscribe(client=>{
this.resetSeance();
this.editForm=false;

})
}

}
