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
import { DeleteComponent } from './compononents/delete/delete.component';
import { VerticalNavbarComponent } from './compononents/vertical-navbar/vertical-navbar.component';
import { FooterComponent } from './compononents/footer/footer.component';
import { HeaderComponent } from './compononents/header/header.component';

// import { MaterializeModule } from 'angular-materialize';


const appRoutes : Routes= [
  {
    path: 'salaries',
    component : SalarieComponent
  },
  {
    path: Pilote.name.toLowerCase()+"s",
    component : PiloteComponent
  },
  {
    path:':model/delete/:id',
    component:DeleteComponent
  },
  { path: '',redirectTo: Pilote.name.toLowerCase()+"s", pathMatch: 'full' },
]

@NgModule({
  declarations: [
    AppComponent,
    SalarieComponent,
    ListComponent,
    AddComponent,
    PiloteComponent,
    DeleteComponent,
    VerticalNavbarComponent,
    FooterComponent,
    HeaderComponent
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
