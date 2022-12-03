import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplianceComponent } from './component/appliance/appliance.component';
import { ClientComponent } from './component/client/client.component';
import { ContactComponent } from './component/contact/contact.component';
import { PovComponent } from './component/pov/pov.component';
import { SeanceComponent } from './component/seance/seance.component';
import { SuiviComponent } from './component/suivi/suivi.component';
import { TypePrestationComponent } from './component/type-prestation/type-prestation.component';
import { TypeComponent } from './component/type/type.component';

const routes: Routes = [
  
  {
    path : 'type',
    component : TypeComponent
  },
  {
    path : 'appliance',
    component : ApplianceComponent
  },
  {
    path : 'client',
    component : ClientComponent
  },
  {
    path : 'contact',
    component : ContactComponent
  },
  {
    path : 'pov',
    component : PovComponent
  },
  {
    path : 'seance',
    component : SeanceComponent
  },
  {
    path : 'suivi',
    component : SuiviComponent
  },
  {
    path : 'typePrestation',
    component : TypePrestationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
