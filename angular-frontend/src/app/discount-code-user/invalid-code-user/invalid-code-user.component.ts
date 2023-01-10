import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-invalid-code-user',
  templateUrl: './invalid-code-user.component.html',
  styleUrls: ['./invalid-code-user.component.css']
})
export class InvalidCodeUserComponent implements OnInit {

  constructor(private router: Router) { }
  code=''
  ngOnInit(): void {
  }
  add() {
    if(this.code!=''){
      this.router.navigate(['successCode']);
    }
    else{
      this.router.navigate(['invalidCode']);
    }
  }

  cancel() {
    this.router.navigate(['cancelCode']);
  }
}
