import { Component, OnInit } from '@angular/core';
import { Salarie } from 'src/app/models/salarie';
import { SalarieService } from 'src/app/service/salarie.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  salaries;
  constructor(private salarieservice:SalarieService, router:Router,route:ActivatedRoute) { }

  ngOnInit() {
    this.salarieservice.getAllSalaries().subscribe(data=>{console.log(data);this.salaries=data});
  }

}
