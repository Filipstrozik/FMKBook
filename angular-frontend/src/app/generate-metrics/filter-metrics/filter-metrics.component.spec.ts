import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterMetricsComponent } from './filter-metrics.component';

describe('GenerateMetricsComponent', () => {
  let component: FilterMetricsComponent;
  let fixture: ComponentFixture<FilterMetricsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterMetricsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FilterMetricsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
