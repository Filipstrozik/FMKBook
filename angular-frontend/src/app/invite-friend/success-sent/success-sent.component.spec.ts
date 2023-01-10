import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessSentComponent } from './success-sent.component';

describe('SuccessSentComponent', () => {
  let component: SuccessSentComponent;
  let fixture: ComponentFixture<SuccessSentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuccessSentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuccessSentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
