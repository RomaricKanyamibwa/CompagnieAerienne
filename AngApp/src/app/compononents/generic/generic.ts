import { GenericService } from 'src/app/service/generic.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';


export type ViewType = 'list' | 'add';
export class Generic<T> {
    form: FormGroup;
    models;
    tabTitles;
    modelsProps;
    formTitles;
    // editor:ViewType = 'list';

    constructor(private modelService: GenericService<T>, private router: Router,public formBuilder:FormBuilder) { }

    get showListView() {
        return VerticalNavbarComponent.editor === 'list';
      }
    
      get showAddView() {
        console.log(VerticalNavbarComponent.editor);
        return VerticalNavbarComponent.editor === 'add';
      }

    getAllModels() {
        this.modelService.getAllModels().subscribe(data => { console.log(data); this.models = data });
    }

    create() {

    }


}
