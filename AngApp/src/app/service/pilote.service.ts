import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { AppSettings } from '../settings/app.settings';
import { Pilote } from '../models/pilote';

@Injectable({
  providedIn: 'root'
})
export class PiloteService {

  constructor() { }
}
