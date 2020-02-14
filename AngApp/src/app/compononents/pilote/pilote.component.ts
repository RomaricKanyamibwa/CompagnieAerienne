import { Component, OnInit } from '@angular/core';
import { Generic } from '../generic/generic';
import { Pilote } from 'src/app/models/pilote';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';
import { Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-pilote',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./pilote.component.css']
})
export class PiloteComponent extends Generic<Pilote> implements OnInit {

  model:Pilote;
  constructor(modelService: GenericService<Pilote>,
    router: Router,
    formBuilder:FormBuilder) {
    console.log("NANANAN");
    super(modelService, router,formBuilder);
    this.model=new Pilote();
    modelService.setPath(Pilote.name);
  }

  ngOnInit() {
    console.log("ON Init");
    this.getAllModels();
    this.tabTitles = ["#", "Nom", "Prenom", "Action"];
    this.formTitles = { "Nom": "nomPilote", "Prenom": "prenomPilote" };
    this.modelsProps = Object.keys(new Pilote())
    this.form = this.formBuilder.group
      (
        {
          nomPilote: ['', Validators.required],
          prenomPilote: ['', Validators.required]
        }
      )
}

}
