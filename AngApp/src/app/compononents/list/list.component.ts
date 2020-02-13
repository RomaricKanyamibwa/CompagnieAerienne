import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  @Input() models;
  @Input() tabTitles;
  @Input() modelsProps;
  constructor() {
    
  }

  ngOnInit() {
    console.log(this.modelsProps);
  }

}
