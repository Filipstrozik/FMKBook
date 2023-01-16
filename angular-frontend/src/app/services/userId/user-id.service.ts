import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserIdService {
  number = 1
  constructor() {

  }
  setNumber(number: number){
    this.number = number;
  }
  getNumber(): number{
    return this.number
  }
}
