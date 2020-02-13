import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SalarieComponent } from './compononents/salarie/salarie.component';

import {Routes,RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ListComponent } from './compononents/list/list.component';
import { AddComponent } from './compononents/add/add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PiloteComponent } from './compononents/pilote/pilote.component';
import { Pilote } from './models/pilote';

// import { MaterializeModule } from 'angular-materialize';


const appRoutes : Routes= [
  {
    path: 'salaries',
    component : SalarieComponent
  },
  {
    path: Pilote.name.toLowerCase()+"s",
    component : PiloteComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    SalarieComponent,
    ListComponent,
    AddComponent,
    PiloteComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    // MaterializeModule
    // AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
