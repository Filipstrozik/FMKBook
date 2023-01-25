import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IpServiceService {

  private _ip: string = '10.182.36.179';
  constructor() { }


  get ip(): string {
    return this._ip;
  }

  set ip(value: string) {
    this._ip = value;
  }
}
