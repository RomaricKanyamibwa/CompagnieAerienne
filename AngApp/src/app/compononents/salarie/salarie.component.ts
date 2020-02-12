import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormGroup,FormBuilder, Validators} from '@angular/forms';
import {SalarieService} from '../../service/salarie.service'

@Component({
  selector: 'app-salarie',
  templateUrl: './salarie.component.html',
  styleUrls: ['./salarie.component.css']
})
export class SalarieComponent implements OnInit {
  form : FormGroup;
  //constructor(private formBuilder:FormBuilder,private salarieService:SalarieService,
  //private router:Router) { }
   constructor(private salarieService:SalarieService,private router:Router) { }

  ngOnInit() {
    //   this.form =this.formBuilder.group({
    //     nom:['',Validators.required],
    //     prenom:['',Validators.required],
    //     numsecu:['',Validators.required],
    
    //  });
    this.getAllSalaries();
  }

  getAllSalaries()
  {
    return this.salarieService.getAllSalaries().subscribe(data=>console.log(data));
  }

  create()
  {
    
  }
}
