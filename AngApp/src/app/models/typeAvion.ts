import { Model } from './model';
import { Constructeur } from './constructeur';

export class TypeAvion extends Model {

    typeAvion:string;
    capacite:number;
    constructeur:Constructeur;

    constructor()
    {
        super();
        this.typeAvion="";
        this.capacite=100;
        this.constructeur=new Constructeur();
    }

}