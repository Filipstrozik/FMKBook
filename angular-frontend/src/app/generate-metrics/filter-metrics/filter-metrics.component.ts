import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-generate-metrics',
  templateUrl: './filter-metrics.component.html',
  styleUrls: ['./filter-metrics.component.css']
})
export class FilterMetricsComponent {

  startDate?: string;
  endDate?: string;

  constructor(private router: Router) { }

  onFilter() {
    this.router.navigate(['/results'], { queryParams: { startDate: this.startDate, endDate: this.endDate } });
  }

}
