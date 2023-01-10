import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessCodeComponent } from './success-code.component';

describe('SuccessCodeComponent', () => {
  let component: SuccessCodeComponent;
  let fixture: ComponentFixture<SuccessCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuccessCodeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuccessCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
