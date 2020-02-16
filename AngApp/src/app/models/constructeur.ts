import { Model } from './model';

export class Constructeur extends Model {
    idConstructeur:number;
    nomConstructeur:string;

    constructor()
    {
        super();
        
        this.idConstructeur=0;
        this.nomConstructeur=""
    }

}
