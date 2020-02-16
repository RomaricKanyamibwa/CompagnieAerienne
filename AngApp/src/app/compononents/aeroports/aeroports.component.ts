import { Component, OnInit } from '@angular/core';
import { Aeroport } from 'src/app/models/aeroport';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Generic } from '../generic/generic';
import { GenericService } from 'src/app/service/generic.service';
import { GlobalValues } from 'src/app/global-values';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';

@Component({
  selector: 'app-aeroports',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./aeroports.component.css']
})
export class AeroportsComponent extends Generic<Aeroport> implements OnInit {

  constructor(modelService: GenericService<Aeroport>,
    router: Router,
    formBuilder: FormBuilder) {
    super(modelService, router, formBuilder);
    modelService.setPath(Aeroport.name);
  }

  ngOnInit() {
    this.getAllModels();
    VerticalNavbarComponent.editor="list";
    this.tabTitles = ["IdAeroport", "Nom Aeroport", "Ville Deservie", "Action"];
    this.formTitles = { "IdAeroport": "idAeroport", "Nom Aeroport": "nomAeroport", "Ville Deservie": "nomVilleDesservie" };
    this.modelsProps = Object.keys(new Aeroport())
    // console.log(this.formTitles,this.modelsProps);
    this.initForm();
  }

  private initForm(): void {
    this.form = this.formBuilder.group
      (
        {
          idAeroport: ['', [Validators.required, Validators.maxLength(3), Validators.pattern("[A-Z]{3}")]],
          nomAeroport: ['', [Validators.required, Validators.maxLength(25), Validators.pattern(GlobalValues.letterPatern + "{3,25}")]],
          nomVilleDesservie: ['', [Validators.maxLength(50), Validators.pattern(GlobalValues.letterPatern + "{0,50}")]]
        }
      )
  }

  onAdded(added: boolean) {
    this.initForm();
    this.getAllModels();
  }

  toBeUpdated(model: Aeroport): void {
    console.log(`The entity with id${model.idAeroport} retrieved`);
    this.model = model;
    VerticalNavbarComponent.editor = "edit";
    this.formEdit = this.formBuilder.group
      (
        {
          idAeroport: [this.model.idAeroport, [Validators.required, Validators.maxLength(3), Validators.pattern("[A-Z]{3}")]],
          nomAeroport: [this.model.nomAeroport,[Validators.required, Validators.maxLength(25), Validators.pattern(GlobalValues.letterPatern + "{3,25}")]],
          nomVilleDesservie:[this.model.nomVilleDesservie,[Validators.maxLength(50),Validators.pattern(GlobalValues.letterPatern+"{0,50}")]]
        }
      )
  }

}
