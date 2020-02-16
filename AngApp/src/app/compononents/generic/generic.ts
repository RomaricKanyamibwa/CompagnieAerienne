import { GenericService } from 'src/app/service/generic.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { VerticalNavbarComponent } from '../vertical-navbar/vertical-navbar.component';



export class Generic<T> {
    form: FormGroup;
    formEdit: FormGroup;
    models;
    tabTitles;
    modelsProps;
    formTitles;
    model:T;
    // editor:ViewType = 'list';

    constructor(protected modelService: GenericService<T>, private router: Router,public formBuilder:FormBuilder) { }

    get showListView() {
        return VerticalNavbarComponent.editor === 'list';
      }
    
      get showAddView() {
        // console.log(VerticalNavbarComponent.editor);
        return VerticalNavbarComponent.editor === 'add';
      }

      get showEditView() {
        return VerticalNavbarComponent.editor === 'edit';
      }

    getAllModels() {
        this.modelService.getAllModels().subscribe(data => { console.log(data); this.models = data });
    }



    onAdded(added: boolean) {
        this.getAllModels();
      }

     toBeUpdated(model:T):void
    {
        console.log(`The entity to be updated is ${model}`);
        this.model=model;
        VerticalNavbarComponent.editor="edit";
    }


}
