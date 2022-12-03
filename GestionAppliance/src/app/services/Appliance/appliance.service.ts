import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appliance } from 'src/app/Model/appliance';


@Injectable({
  providedIn: 'root'
})
export class ApplianceService {

  constructor(private http:HttpClient) { }
  persist(appliance : Appliance) {
    // console.log(appliance);
    return this.http.post<Appliance>("http://localhost:8080/Appliance/add",appliance);
   }
    findAll(page : number, size :number){
      console.log(size);
      return this.http.get<any>("http://localhost:8080/Appliance/Find?page="+page+"&size="+size);
    }
  
    delete(id:number){
      return this.http.delete('http://localhost:8080/Appliance/Delete/'+id);  //500
    }
    
    update(appliance:any){
      return this.http.put<Appliance>('http://localhost:8080/Appliance/Update/'+appliance.idAppliance,appliance);
  
    }

    findAllType(){
      return this.http.get<any>("http://localhost:8080/Type/Findtp");
    }
}
