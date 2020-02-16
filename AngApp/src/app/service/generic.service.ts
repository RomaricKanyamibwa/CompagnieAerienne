import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppSettings } from '../settings/app.settings';
import { MessageService } from './message.service';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

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
  constructor(private http:HttpClient,
    private messageService: MessageService) {
   }

  setPath(className:String)
  {
    this.modelName=className.toLowerCase();
    this.pathModel=AppSettings.APP_URL+"/"+this.modelName+"s/";
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
      return this.http.get(this.pathModel).pipe(
        tap(_ => console.log('fetched '+this.modelName+'s')),
        catchError(this.handleError<any[]>('get'+this.modelName+'s', []))
      );
    }

  createModel(model:T)
  {
    return this.http.post(this.pathModel,model);
  }

  saveModel(model:T)
  {
    return this.http.post(this.pathModel,JSON.stringify(model),this.httpOptions);
  }

  deleteModel(id)
  {
    // console.log(this.modelName+"s/"+id);
    return this.http.delete(this.pathModel+id,this.httpOptions).pipe(
      tap(_ => console.log(`deleted `+this.modelName+` id=${id}`)),
      catchError(this.handleError<any>('delete'+this.modelName))
    );
  }

  getModel(id:number|string)
  {
    const url = `${this.pathModel}${id}`;
    // console.log("url:",url)
    return this.http.get<T>(url).pipe(
      tap(_ => console.log(`fetched ${this.modelName} id=${id}`)),
      catchError(this.handleError<T>(`get${this.modelName} id=${id}`))
    );
  }

  updateModel(model:T,id:number|string)
  {
    return this.http.put(this.pathModel,JSON.stringify(model),this.httpOptions).pipe(
      tap(_ => console.log(`updated ${this.modelName} id=${id}`)),
      catchError(this.handleError<any>('update${this.modelName}'))
    );
  }

  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
