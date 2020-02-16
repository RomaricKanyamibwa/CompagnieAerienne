import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor() { }
  messages: string[] = [];

  add(message: string) {
    this.messages.push(message);
  }

  consolePrint():void
  {
    console.log(this.messages);
    this.clear();
  }

  clear() {
    this.messages = [];
  }
}
