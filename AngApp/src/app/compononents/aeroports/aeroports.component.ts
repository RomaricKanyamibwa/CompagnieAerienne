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
    this.tabTitles = ["IdAeroport", "Nom Aeroport", "Ville Deservie", "Action"];
    this.formTitles = { "IdAeroport": "idAeroport", "Nom Aeroport": "nomAeroport", "Ville Deservie": "nomVilleDesservie" };
    this.modelsProps = Object.keys(new Aeroport())
    this.initForm();
  }

  private initForm(): void {
    this.form = this.formBuilder.group
      (
        {
          nomAeroport: ['', [Validators.required, Validators.maxLength(3), Validators.pattern("[A-Z]{3}")]],
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
          idAeroport: [this.model.idAeroport, [Validators.nullValidator]],
          nomAeroport: [this.model.nomAeroport, [Validators.required, Validators.maxLength(3), Validators.pattern("[A-Z]{3}")]],
          nomVilleDesservie:[this.model.nomVilleDesservie,[Validators.maxLength(50),Validators.pattern(GlobalValues.letterPatern+"{0,50}")]]
        }
      )
  }

}
