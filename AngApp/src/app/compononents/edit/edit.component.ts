import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';
import { GenericService } from 'src/app/service/generic.service';
import { Pilote } from 'src/app/models/pilote';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  @Input() form: FormGroup;
  @Input() modelService:GenericService<Pilote>;
  @Input() formTitles;
  @Input() model;
  @Input() idModel: number | string;
  @Output() added = new EventEmitter<boolean>();
  didadd=false;

  constructor() {
  }

  ngOnInit() {
    console.log(this.model);
  }

  update() {
    console.log(this.form.value);
    this.modelService.updateModel(this.form.value,this.idModel).subscribe(res => {
      //console.log("Value modified==>"+this.modelService.getModelName());
      VerticalNavbarComponent.editor='list';
      this.add(true);
      //this.router.navigate([this.modelService.getModelName()+"s"]);
    })
  }

  add(added: boolean) {
    this.added.emit(added);
    this.didadd = true;
  }

  goBack(): void {
    VerticalNavbarComponent.editor="list";
    }

}
