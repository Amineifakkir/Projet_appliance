import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ApplianceComponent } from './component/appliance/appliance.component';
import { SuiviComponent } from './component/suivi/suivi.component';
import { TypeComponent } from './component/type/type.component';
import { ContactComponent } from './component/contact/contact.component';
import { ClientComponent } from './component/client/client.component';
import { PovComponent } from './component/pov/pov.component';
import { SeanceComponent } from './component/seance/seance.component';
import { TypePrestationComponent } from './component/type-prestation/type-prestation.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    ApplianceComponent,
    SuiviComponent,
    TypeComponent,
    ContactComponent,
    PovComponent,
    SeanceComponent,
    TypePrestationComponent,
    ClientComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
