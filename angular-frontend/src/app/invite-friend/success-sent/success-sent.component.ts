import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-success-sent',
  templateUrl: './success-sent.component.html',
  styleUrls: ['./success-sent.component.css']
})
export class SuccessSentComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  back() {
    this.router.navigate(['']);
  }
}
