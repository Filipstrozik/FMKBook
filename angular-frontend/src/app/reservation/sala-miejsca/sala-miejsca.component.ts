import { Component, OnInit } from '@angular/core';
import {MiejsceService} from "../../services/miejsce/miejsce.service";
import {SeansService} from "../../services/seans/seans.service";
import {Miejsce} from "../../miejsce.model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-sala-miejsca',
  templateUrl: './sala-miejsca.component.html',
  styleUrls: ['./sala-miejsca.component.css']
})
export class SalaMiejscaComponent implements OnInit {
  seansId: number;
  miejscaList: Miejsce[];
  rows = [1,2];
  selectedMiejsca: Miejsce[];


  constructor(private miejsceService: MiejsceService,
              private seansService: SeansService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.seansId = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.miejsceService.getMiejscaBySeans(this.seansId).subscribe( data => {
      this.miejscaList = data;
    })
  }

}
