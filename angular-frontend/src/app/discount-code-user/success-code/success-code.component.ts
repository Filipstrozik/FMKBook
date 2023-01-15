import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-success-code',
  templateUrl: './success-code.component.html',
  styleUrls: ['./success-code.component.css']
})
export class SuccessCodeComponent implements OnInit {
  code='DEF1234';
  discount='75';
  myParam='';
  constructor(private router: Router, private route: ActivatedRoute)  {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.myParam = params['rabat']);
    this.code = this.myParam;
  }
  back() {
    this.router.navigate(['']);
  }
}
