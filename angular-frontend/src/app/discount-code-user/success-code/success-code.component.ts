import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-success-code',
  templateUrl: './success-code.component.html',
  styleUrls: ['./success-code.component.css']
})
export class SuccessCodeComponent implements OnInit {

  constructor(private router: Router) { }
  code='DEF1234'
  discount='75'
  ngOnInit(): void {
  }
  back() {

    this.router.navigate(['']);
  }
}
