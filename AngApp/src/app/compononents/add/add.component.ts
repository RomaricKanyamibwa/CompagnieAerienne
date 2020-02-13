import { Component, OnInit, Input } from '@angular/core';
import {FormBuilder,FormGroup, Validators } from '@angular/forms'
import { SalarieService } from 'src/app/service/salarie.service';
import { Router } from '@angular/router';
import { GenericService } from 'src/app/service/generic.service';
import { Salarie } from 'src/app/models/salarie';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  form:FormGroup;
  @Input() modelService;//:GenericService<Salarie>;
  @Input()tabTitles;
  @Input() modelsProps;

  constructor(private formBuilder:FormBuilder,
    private router:Router) {
     }

  ngOnInit() {
    //this.tabTitles.shift();
    //this.tabTitles.pop();
    //this.modelsProps.shift();
    //this.tabTitles=this.tabTitles.sort();
    //this.modelsProps=this.modelsProps.sort();

    console.log(this.tabTitles,this.modelsProps);
    console.log(new Map([this.modelsProps,this.tabTitles]));
    this.form=this.formBuilder.group
    (
      {
        nom:['',Validators.required],
        prenom:['',Validators.required],
        numsecu:['',Validators.required]
      }
    )
  }

  create()
  {
    console.log(this.form.value);
    this.modelService.saveModel(this.form.value).subscribe(res=>
    {console.log("Value ADDED");this.router.navigate(['/hehbebh/'])})
  }

}
