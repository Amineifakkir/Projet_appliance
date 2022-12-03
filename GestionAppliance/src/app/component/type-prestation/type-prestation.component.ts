import { Component, OnInit } from '@angular/core';
import { TypePrestation } from 'src/app/Model/type-prestation';
import { TypePrestationService } from 'src/app/services/TypePrestation/type-prestation.service';

@Component({
  selector: 'app-type-prestation',
  templateUrl: './type-prestation.component.html',
  styleUrls: ['./type-prestation.component.css']
})
export class TypePrestationComponent implements OnInit {

  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;

    MytypePrestation :TypePrestation={
      libelle: '',
      idTypePres: 0
      
    }
    typePrestations: TypePrestation[]=[];
   
  constructor(private typePrestationService: TypePrestationService) { }

  ngOnInit(): void {
    this.getTypes(0,this.itemsPerPage);
    
  }

  getTypes(page: number, size: number){
    this.typePrestationService.findAll(page,size).subscribe(types =>{
     
      this.typePrestations = types.pages;
      this.totalItems = types.totalItems;
      console.log(types);
  
  })
  }
  deleteType(id:number){
    this.typePrestationService.delete(id)
    .subscribe(() => {this.typePrestations=this.typePrestations.filter(typePrestation=>typePrestation.idTypePres != id)})
  }
persistType(f:any){
  f.value as TypePrestation
  this.typePrestationService.persist(f.value).subscribe((typePrestation)=>this.typePrestations =[typePrestation , ...this.typePrestations]);
  this.resetType();
  
}

pageChanged($event: number) {
  this.currentPage = $event;
  this.getTypes(this.currentPage - 1, this.itemsPerPage)
}

editType(typePrestation:any){
this.MytypePrestation=  typePrestation;
this.editForm=true;
}

resetType(){
  this.MytypePrestation={
  
    idTypePres:0
  }
}
updateType(){
this.typePrestationService.update(this.MytypePrestation).subscribe(type=>{
  this.resetType();
  this.editForm=false;

})
}

}
