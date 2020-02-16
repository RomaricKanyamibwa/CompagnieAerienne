import { Model } from './model';

export class Aeroport extends Model{
    idAeroport: string;
    nomAeroport: string;
    nomVilleDesservie:string;
    constructor()
    {
        super();
        this.idAeroport="";
        this.nomAeroport=""
        this.nomVilleDesservie=""
    }
}
