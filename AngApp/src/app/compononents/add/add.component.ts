import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup, Validators } from '@angular/forms'
import { SalarieService } from 'src/app/service/salarie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  form:FormGroup;
  constructor(private formBuilder:FormBuilder
    ,private salarieService:SalarieService,
    private router:Router) { }

  ngOnInit() {
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
    this.salarieService.saveSalarie(this.form.value).subscribe(res=>
    {console.log("Value ADDED");this.router.navigate(['/hehbebh/'])})
  }

}
