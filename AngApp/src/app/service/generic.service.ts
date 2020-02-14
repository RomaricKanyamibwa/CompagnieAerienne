import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppSettings } from '../settings/app.settings';

@Injectable({
  providedIn: 'root'
})
export class GenericService<T>{

  httpOptions={
    headers: new HttpHeaders({'Content-Type':'application/json'})
  }
  pathModel;
  modelName;
  h:T&Function;
  constructor(private http:HttpClient) {
   }

  setPath(className:String)
  {
    this.modelName=className.toLowerCase();
    this.pathModel=AppSettings.APP_URL+"/"+className.toLowerCase()+"s/";
  }

  getPath()
  {
    return this.pathModel;
  }

  getModelName()
  {
    return this.modelName;
  }

  getAllModels()
    {
      return this.http.get(this.pathModel);
    }

  createModel(model:T)
  {
    return this.http.post(this.pathModel,model);
  }

  saveModel(model:T)
  {
    return this.http.post(this.pathModel,JSON.stringify(model),this.httpOptions);
  }

  editModel(id:number)
  {
    return this.http.get(this.pathModel);
  }

  updateModel(model:T)
  {
    return this.http.put(this.pathModel,JSON.stringify(model),this.httpOptions);
  }
}
