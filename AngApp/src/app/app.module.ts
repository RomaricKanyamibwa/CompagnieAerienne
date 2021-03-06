import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {Routes,RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ListComponent } from './compononents/list/list.component';
import { AddComponent } from './compononents/add/add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PiloteComponent } from './compononents/pilote/pilote.component';
import { Pilote } from './models/pilote';
import { VerticalNavbarComponent } from './compononents/vertical-navbar/vertical-navbar.component';
import { FooterComponent } from './compononents/footer/footer.component';
import { HeaderComponent } from './compononents/header/header.component';
import { EditComponent } from './compononents/edit/edit.component';
import { AeroportsComponent } from './compononents/aeroports/aeroports.component';
import { Aeroport } from './models/aeroport';
import { ConstructeursComponent } from './compononents/constructeurs/constructeurs.component';
import { Constructeur } from './models/constructeur';
import { TypeComponent } from './compononents/type/type.component';
import { TypeAvion } from './models/typeAvion';
import { HomeComponent } from './compononents/home/home.component';
// import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

// import { MaterializeModule } from 'angular-materialize';


const appRoutes : Routes= [
  {
    path:'',
    component:HomeComponent

  },
  {
    path: Pilote.name.toLowerCase()+"s",
    component : PiloteComponent
  },
  {
    path: Aeroport.name.toLowerCase()+"s",
    component : AeroportsComponent
  },
  {
    path: Constructeur.name.toLowerCase()+"s",
    component : ConstructeursComponent
  },
  {
    path: TypeAvion.name.toLowerCase()+"s",
    component : TypeComponent
  },
  // {
  //   path:Pilote.name.toLowerCase()+"s"+'/edit/:id',
  //   component:PiloteComponent
  // },
  { path: '',redirectTo: Pilote.name.toLowerCase()+"s", pathMatch: 'full' },
]

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    AddComponent,
    PiloteComponent,
    VerticalNavbarComponent,
    FooterComponent,
    HeaderComponent,
    EditComponent,
    AeroportsComponent,
    ConstructeursComponent,
    TypeComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    // FontAwesomeModule,
    // MaterializeModule
    // AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
