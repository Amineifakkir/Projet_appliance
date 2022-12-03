import { NonNullAssert } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Pov } from 'src/app/Model/pov';
import { Suivi } from 'src/app/Model/suivi';
import { TypePrestation } from 'src/app/Model/type-prestation';
import { SuiviService } from 'src/app/services/Suivi/suivi.service';

@Component({
  selector: 'app-suivi',
  templateUrl: './suivi.component.html',
  styleUrls: ['./suivi.component.css']
})
export class SuiviComponent implements OnInit {

  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;
  // types: Type[]=[];
suivis :Suivi[]=[];
povs :Pov[]=[];
typePrestations :TypePrestation[]=[];

  
    Mysuivi :Suivi={
      idSuivi:0,
      typePres: {idTypePres:0},
      povSuivi:{idPov:0,idClient:{idClt:0},idAppliance : {idAppliance:0,idType:{idType: 0}}
       
      },
      
}
  constructor(private suiviService: SuiviService) { }

  ngOnInit(): void {
    this.getSuivi(0,this.itemsPerPage);
    this.getTypes();
    this.getPov();
  }



getSuivi(page: number, size: number){
  this.suiviService.findAll(page,size).subscribe(suivis =>{
   
    this.suivis = suivis.pages;
    this.totalItems = suivis.totalItems;
    console.log(suivis);

})

}
pageChanged($event: number) {
  this.currentPage = $event;
  this.getSuivi(this.currentPage - 1, this.itemsPerPage)
}
getPov(){
  this.suiviService.findAllPov().subscribe(pov =>{
    this.povs=pov
    console.log(pov);
  } )

}
getTypes(){
    this.suiviService.findAllPrestation().subscribe(typePrestations =>{
      // console.log(typePrestations);
      this.typePrestations=typePrestations})

  }

deleteSuivi(id:number){
  this.suiviService.delete(id)
  .subscribe(() => {this.suivis=this.suivis.filter(suivi=>suivi.idSuivi != id)})
}
persistSuivi(f:any){
  // f.value as Suivi
this.suiviService.persist(f.value).pipe(take(1)).subscribe((suivi)=>this.suivis =[suivi , ...this.suivis]);
this.resetSuivi();

}
editSuivi(suivi:any){
this.Mysuivi=  suivi;
this.editForm=true;
}
resetSuivi(){
this.Mysuivi={
  idSuivi:0,
      typePres: {idTypePres:0},
      povSuivi:{idPov:0,idClient:{idClt:0},idAppliance : {idAppliance:0,idType:{idType: 0}}
       
      },
      
}
}
updateSuivi(){
this.suiviService.update(this.Mysuivi).subscribe(suivi=>{
this.resetSuivi();
this.editForm=false;

})
}
}


