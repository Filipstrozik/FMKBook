import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RabatService} from "../../services/rabat/rabat.service";
import {UserIdService} from "../../services/userId/user-id.service";


@Component({
  selector: 'app-add-code-user',
  templateUrl: './add-code-user.component.html',
  styleUrls: ['./add-code-user.component.css']
})
export class AddCodeUserComponent implements OnInit {
  code = '';
  hidden = 'none';

  constructor(private router: Router,
              private rabatService: RabatService,
              private userIdService: UserIdService) {
  }

  ngOnInit(): void {
  }

  add() {
    let userId = this.userIdService.getNumber()
    console.log(this.userIdService.getNumber())
    this.rabatService.updateRabat(userId, this.code).subscribe(data => {

      this.router.navigate(['successCode', this.code]);
    });
    this.hidden = 'block'
  }

  cancel() {
    this.router.navigate(['cancelCode']);
  }
}
