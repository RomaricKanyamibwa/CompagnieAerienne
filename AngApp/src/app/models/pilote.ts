import { Model } from './model';

export class Pilote extends Model {
    idPilote:number;
    nomPilote:string;
    prenomPilote:string;
    constructor()
    {
        super();
        this.idPilote=0;
        this.nomPilote="";
        this.prenomPilote="";

    }
}
