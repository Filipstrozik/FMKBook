import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-code-user',
  templateUrl: './add-code-user.component.html',
  styleUrls: ['./add-code-user.component.css']
})
export class AddCodeUserComponent implements OnInit {
  code = '';
  constructor(private router: Router) { }

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
