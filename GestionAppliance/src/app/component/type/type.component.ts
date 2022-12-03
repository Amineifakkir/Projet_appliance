import { Component, OnInit} from '@angular/core';
import { TypeService } from 'src/app/services/Type/type.service';
import{Type}from'src/app/Model/type';
// import { NgModel } from '@angular/forms';
// import {MatDialog, MatDialogConfig} from "@angular/material";
// import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.css']
})


export class TypeComponent implements OnInit {
  showForm=false;
  editForm = false;
  itemsPerPage: number = 5;
  currentPage: number = 1;
  totalItems: number = 0;

    Mytype :Type={
      
      idType: 0
      
    }
   types: Type[]=[];
   
  constructor(private typeService: TypeService) { }

  ngOnInit(): void {
    this.getTypes(0,this.itemsPerPage);
    
  }

  getTypes(page: number, size: number){
    this.typeService.findAll(page,size).subscribe(types =>{
     
      this.types = types.pages;
      this.totalItems = types.totalItems;
      console.log(types);
  
  })
  }
  deleteType(id:number){
    this.typeService.delete(id)
    .subscribe(() => {this.types=this.types.filter(type=>type.idType != id)})
  }
  pageChanged($event: number) {
    this.currentPage = $event;
    this.getTypes(this.currentPage - 1, this.itemsPerPage)
  }
persistType(f:any){
f.value as Type
  this.typeService.persist(f.value).subscribe((type)=>this.types =[type , ...this.types]);
  this.resetType();
  
}
resetType(){
  this.Mytype={
    idType:0
  }
}

editType(type:any){
this.Mytype=type;
console.log(type);
this.editForm=true;
}

updateType(){
this.typeService.update(this.Mytype).subscribe(type=>{
  console.log(this.Mytype);
  this.resetType();
  this.editForm=false;

})
}

}

