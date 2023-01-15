import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RabatService} from "../../services/rabat/rabat.service";


@Component({
  selector: 'app-add-code-user',
  templateUrl: './add-code-user.component.html',
  styleUrls: ['./add-code-user.component.css']
})
export class AddCodeUserComponent implements OnInit {
  code = '';
  idUser = 1;
  hidden = 'none';

  constructor(private router: Router, private rabatService: RabatService) {
  }

  ngOnInit(): void {
  }

  add() {

    this.rabatService.updateRabat(this.idUser, this.code).subscribe(data => {

      this.router.navigate(['successCode', this.code]);
    });
    this.hidden = 'block'
  }

  cancel() {
    this.router.navigate(['cancelCode']);
  }
}
