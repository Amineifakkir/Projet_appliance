import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Appliance } from 'src/app/Model/appliance';
import { Type } from 'src/app/Model/type';
import { ApplianceService } from 'src/app/services/Appliance/appliance.service';



@Component({
  selector: 'app-appliance',
  templateUrl: './appliance.component.html',
  styleUrls: ['./appliance.component.css']
})
export class ApplianceComponent implements OnInit {

  showForm = false;
  editForm = false;
// viewby : number=5;
//  itemsPerPage: number =5;
//   currentPage: number = 1;
//   totalItems: number = 0;
  p:number=1;
  page:number=0;
  itemNumber :number =3;
  params:any;
  pageSize : number=3;
  pageSizes =[3,6,9,20,40,70,100];
  appliancePerPage:any;


  types: Type[] = [];

  appliances: Appliance[] = [];


  Myappliance: Appliance = {
    idAppliance: 0,
    
    idType: {
      idType: 0

    },
    
  }

  constructor(private appliancService: ApplianceService ) { }

  ngOnInit(): void {
    this.getAppliance();
    this.getTypes();
    // this.retrieveTutorials();
    
  }

 
  

  getTypes() {
    this.appliancService.findAllType().subscribe(types =>
       { 
        this.types = types;
      // console.log(types);
     })
  }

  
  
  // retrieveTutorials() {
  //   // const params = this.getRequestParams(this.title, this.page, this.pageSize);
  //   // const params ='';
    
    
    
  //   this.appliancService.findAll(this.page,this.pageSize)
  //     .subscribe(
  //       response => {
  //         // console.log("page :"+this.page);
  //         // console.log("pageSize :"+this.pageSize);
         
  //         this.appliances.content = response;
  //         console.log("vsdfv"+this.appliances.values)
  //         this.appliancePerPage=this.appliances.values
          
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }
  
  getAppliance() {
    this.appliancService.findAll(this.page,this.pageSize).subscribe(appliances => {
      this.appliances=appliances.pageSize;
      this.appliances = appliances.pages;
      this.itemNumber = appliances.totalItems;
      console.log(this.appliances);
  
    });

  }

 pageChanged($event:any) {
 
  this.pageSize = $event.target.value;
  console.log(this.pageSize );
  this.itemNumber=this.pageSize;
  this.getAppliance();
  // this.page = 0;
  // this.retrieveTutorials();
  }

  deleteAppliance(id: number) {
    this.appliancService.delete(id)
      .subscribe(() => { this.appliances = this.appliances.filter(appliance => appliance.idAppliance != id) })
  }

  persistAppliance(f: any) {
    f.value as Appliance;
    this.appliancService.persist(f.value).pipe(take(1)).subscribe((appliance) => this.appliances = [appliance, ...this.appliances]);
    this.resetAppliance();


  }

  
  resetAppliance() {
    this.Myappliance = {
      idAppliance: 0,
    
      idType: {
        idType: 0
  
      }
      
    }
  }
  editAppliance(appliance: any) {
    this.Myappliance = appliance;
    this.editForm = true;
  }
  updateAppliance() {
    this.appliancService.update(this.Myappliance).subscribe(appliance => {
      console.log(this.Myappliance);
      this.resetAppliance();
      this.editForm = false;

    })
  }

}
