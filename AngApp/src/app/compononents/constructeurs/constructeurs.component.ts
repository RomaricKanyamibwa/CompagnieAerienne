import { Component, OnInit } from '@angular/core';
import { Generic } from '../generic/generic';
import { Constructeur } from 'src/app/models/constructeur';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';
import { GlobalValues } from 'src/app/global-values';

@Component({
  selector: 'app-constructeurs',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./constructeurs.component.css']
})
export class ConstructeursComponent extends Generic<Constructeur> implements OnInit {

  constructor(modelService: GenericService<Constructeur>,
    router: Router,
    formBuilder: FormBuilder) {
    super(modelService, router, formBuilder);
    modelService.setPath(Constructeur.name);
  }

  ngOnInit() {
    this.getAllModels();
    VerticalNavbarComponent.editor="list";
    this.tabTitles = ["IdConstructeur", "Nom Constructeur","Action"];
    this.formTitles = { "Nom Constructeur": "nomConstructeur" };
    this.modelsProps = Object.keys(new Constructeur())
    console.log(this.formTitles,this.modelsProps);
    this.initForm();
  }

  private initForm(): void {
    this.form = this.formBuilder.group
      (
        {
          nomConstructeur: ['',
            [Validators.required,Validators.maxLength(25),
               Validators.pattern(GlobalValues.AlphNumPattern+"+")]]
        }
      )
  }

  onAdded(added: boolean) {
    this.initForm();
    this.getAllModels();
  }

  toBeUpdated(model: Constructeur): void {
    console.log(`The entity with id${model.idConstructeur} retrieved`);
    this.model = model;
    VerticalNavbarComponent.editor = "edit";
    this.formEdit = this.formBuilder.group
      (
        {
          idConstructeur: [this.model.idConstructeur],
          nomConstructeur: [this.model.nomConstructeur,
            [Validators.required,Validators.maxLength(25),
               Validators.pattern(GlobalValues.AlphNumPattern+"+")]]
        }
      )
  }


}
