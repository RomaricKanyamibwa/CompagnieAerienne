import { Component, OnInit } from '@angular/core';
import { Generic } from '../generic/generic';
import { Pilote } from 'src/app/models/pilote';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pilote',
  templateUrl: '../generic/generic.html',
  styleUrls: ['./pilote.component.css']
})
export class PiloteComponent extends Generic<Pilote>  implements OnInit {

  constructor(modelService: GenericService<Pilote>,  router: Router) {
    console.log("NANANAN");
    super(modelService,router);
    modelService.setPath(Pilote.name);
  }

  ngOnInit() {
    console.log("ON Init");
    this.getAllModels();
    this.tabTitles= ["#", "Nom", "Prenom", "Action"];
    this.modelsProps = Object.keys(new Pilote())
  }

}
