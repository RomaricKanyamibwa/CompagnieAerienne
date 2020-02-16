import { Component, OnInit, Type } from '@angular/core';
import { Generic } from '../generic/generic';
import { TypeAvion } from 'src/app/models/typeAvion';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';
import { GlobalValues } from 'src/app/global-values';

@Component({
  selector: 'app-type',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./type.component.css']
})
export class TypeComponent extends Generic<TypeAvion> implements OnInit {

  constructor(modelService: GenericService<TypeAvion>,
    router: Router,
    formBuilder: FormBuilder) {
    super(modelService, router, formBuilder);
    modelService.setPath("type");
  }

  ngOnInit() {
    this.getAllModels();
    VerticalNavbarComponent.editor="list";
    this.tabTitles = ["Type Avion", "Capacité", "Constructeur", "Action"];
    this.formTitles = { "Type Avion": "typeAvion", "Capacité": "capacite", "Constructeur": "constructeur.idConstructeur" };
    this.modelsProps = Object.keys(new TypeAvion())
    console.log(this.formTitles,this.modelsProps);
    // console.log("Map:",new Map([2],[323]));
    this.initForm();
  }

  private initForm(): void {
    this.form = this.formBuilder.group
      (
        {
          typeAvion: [, [Validators.required, Validators.maxLength(15), Validators.pattern("^[A-Z][A-Z0-9]+")]],
          capacite: [, [Validators.required,Validators.pattern(GlobalValues.numericPattern)]],
          constructeur: this.formBuilder.group(
            {idConstructeur:[]}
          )      }
      )
  }

  onAdded(added: boolean) {
    this.initForm();
    this.getAllModels();
  }

  toBeUpdated(model: TypeAvion): void {
    console.log(`The entity with id${model.typeAvion} retrieved`);
    this.model = model;
    VerticalNavbarComponent.editor = "edit";
    this.formEdit = this.formBuilder.group
      (
        {
          typeAvion: [this.model.typeAvion, [Validators.required, Validators.maxLength(15), Validators.pattern("^[A-Z][A-Z0-9]+")]],
          capacite: [this.model.capacite, [Validators.required,Validators.pattern(GlobalValues.numericPattern)]],
          constructeur: this.formBuilder.group(
            {idConstructeur:[this.model.constructeur.idConstructeur]}
          )      }
      )
  }

}
