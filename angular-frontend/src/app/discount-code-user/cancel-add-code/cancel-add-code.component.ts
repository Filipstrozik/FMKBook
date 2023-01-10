import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-cancel-add-code',
  templateUrl: './cancel-add-code.component.html',
  styleUrls: ['./cancel-add-code.component.css']
})
export class CancelAddCodeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  back() {
    this.router.navigate(['']);
  }

  addCode() {
    this.router.navigate(['addCode']);
  }
}
