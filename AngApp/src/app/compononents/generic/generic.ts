import { GenericService } from 'src/app/service/generic.service';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Model } from 'src/app/models/model';

export class Generic<T> {
    form: FormGroup;
    models;
    tabTitles;
    modelsProps;

    constructor(private modelService: GenericService<T>, private router: Router) { }

    getAllModels() {
        this.modelService.getAllModels().subscribe(data => { console.log(data); this.models = data });
    }

    create() {

    }
}
