import { Component, OnInit } from '@angular/core';
import { Generic } from '../generic/generic';
import { Pilote } from 'src/app/models/pilote';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';
import { Validators, FormBuilder } from '@angular/forms';
import { GlobalValues } from 'src/app/global-values';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';

@Component({
  selector: 'app-pilote',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./pilote.component.css']
})
export class PiloteComponent extends Generic<Pilote> implements OnInit {

  constructor(modelService: GenericService<Pilote>,
    router: Router,
    formBuilder: FormBuilder) {
    super(modelService, router, formBuilder);
    modelService.setPath(Pilote.name);
  }

  ngOnInit() {
    this.getAllModels();
    VerticalNavbarComponent.editor="list";
    this.tabTitles = ["#", "Nom", "Prenom", "Action"];
    this.formTitles = { "Nom": "nomPilote", "Prenom": "prenomPilote" };
    this.modelsProps = Object.keys(new Pilote())
    // console.log(this.formTitles,this.modelsProps);
    this.initForm();
  }

  private initForm():void{
    this.form = this.formBuilder.group
      (
        {
          nomPilote: ['', [Validators.required, Validators.maxLength(50), Validators.pattern(GlobalValues.letterPatern + "{1,50}")]],
          prenomPilote: ['', [Validators.maxLength(30), Validators.pattern(GlobalValues.letterPatern + "{0,30}")]]
        }
      )
  }

  onAdded(added: boolean) {
    this.initForm();
    this.getAllModels();
  }

  toBeUpdated(model:Pilote): void {
    console.log(`The entity with id${model.idPilote} retrieved`);
    this.model = model;
    VerticalNavbarComponent.editor = "edit";
    this.formEdit = this.formBuilder.group
      (
        {
          idPilote: [this.model.idPilote, [Validators.nullValidator]],
          nomPilote: [this.model.nomPilote, [Validators.required, Validators.maxLength(50), Validators.pattern(GlobalValues.letterPatern + "{1,50}")]],
          prenomPilote: [this.model.prenomPilote, [Validators.maxLength(30), Validators.pattern(GlobalValues.letterPatern + "{0,30}")]]
        }
      )
  }


}
