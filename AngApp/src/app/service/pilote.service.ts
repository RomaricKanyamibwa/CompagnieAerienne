import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { AppSettings } from '../settings/app.settings';
import { Pilote } from '../models/pilote';
import { GenericService } from './generic.service';

@Injectable({
  providedIn: 'root'
})
export class PiloteService extends GenericService<Pilote> {

}
