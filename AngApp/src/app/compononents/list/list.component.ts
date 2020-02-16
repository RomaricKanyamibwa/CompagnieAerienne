import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Generic } from '../generic/generic';
import { Pilote } from 'src/app/models/pilote';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  @Input() models;
  @Input() tabTitles;
  @Input() modelsProps;
  @Input() modelService;//:Generic<Pilote>;
  @Output() toUpdate = new EventEmitter();
  idOfElementToEdit: number | string;


  constructor() {

  }

  ngOnInit() {
    // console.log(this.modelsProps);
  }

  deleteElement(model): void {
    // console.log("ID===>",model[this.modelsProps[0]]);
    this.models = this.models.filter(m => m !== model);
    this.modelService.deleteModel(model[this.modelsProps[0]]).
      subscribe(
        // () => { console.log('success') },
        // () => { console.log('error') }
        );
  }

  update(model) {
    // console.log("onclick",model);
    this.toUpdate.emit(model);
  }

}
