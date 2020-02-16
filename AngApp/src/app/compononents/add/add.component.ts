import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { GenericService } from 'src/app/service/generic.service';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  @Input() form: FormGroup;
  @Input() modelService;//:GenericService<Salarie>;
  @Input() formTitles;
  // @Input() modelsProps;
  // @Input() models;
  @Output() added = new EventEmitter<boolean>();
  didadd=false;

  constructor() {
  }

  ngOnInit() {
  }

  create() {
    // console.log(this.form.value);
    Object.keys(this.form.value).map(k => this.form.value[k] = this.form.value[k].trim());

    this.modelService.saveModel(this.form.value).subscribe(res => {
      console.log("Value ADDED==>"+this.modelService.getModelName());
      VerticalNavbarComponent.editor='list';
      this.add(true);
      //this.router.navigate([this.modelService.getModelName()+"s"]);
    })
  }

  add(added: boolean) {
    this.added.emit(added);
    this.didadd = true;
  }

}
