import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IpServiceService {

  private _ip: string = '192.168.0.80';
  constructor() { }


  get ip(): string {
    return this._ip;
  }

  set ip(value: string) {
    this._ip = value;
  }
}
