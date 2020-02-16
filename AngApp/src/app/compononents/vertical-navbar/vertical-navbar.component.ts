import { Component, OnInit, Input } from '@angular/core';
import { GenericService } from 'src/app/service/generic.service';

export type ViewType = 'list' | 'add' | 'edit';
// export { editor };

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  @Input() modelService;//:GenericService<Salarie>;
  static editor: ViewType = 'list';

  toggleView(type: ViewType) {
    // console.log("Before:",VerticalNavbarComponent.editor);
    VerticalNavbarComponent.editor = type;
    // console.log("After",VerticalNavbarComponent.editor);
    
  }

  constructor() { }

  ngOnInit() {
  }

}
