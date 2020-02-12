import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { AppSettings } from '../settings/app.settings';
import { Salarie } from '../models/salarie';
// import { type } from 'os';

@Injectable({
  providedIn: 'root'
})
export class SalarieService {

  httpOptions={
    headers: new HttpHeaders({'Content-Type':'application/json'})
  }
  apiSalarie=AppSettings.APP_URL+"/salaries/";
  constructor(private http:HttpClient) { }

  getAllSalaries()
    {
      return this.http.get(this.apiSalarie);
    }

  createSalarie(salarie:Salarie)
  {
    return this.http.post(this.apiSalarie,salarie);
  }

  saveSalarie(salarie:Salarie)
  {
    return this.http.post(this.apiSalarie,JSON.stringify(salarie),this.httpOptions);
  }

  editSalarie(id:number)
  {
    return this.http.get(this.apiSalarie);
  }

  updateSalarie(salarie:Salarie)
  {
    return this.http.put(this.apiSalarie,JSON.stringify(salarie),this.httpOptions);
  }
}
