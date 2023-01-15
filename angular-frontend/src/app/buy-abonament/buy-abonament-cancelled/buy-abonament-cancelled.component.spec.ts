import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyAbonamentCancelledComponent } from './buy-abonament-cancelled.component';

describe('BuyAbonamentCancelledComponent', () => {
  let component: BuyAbonamentCancelledComponent;
  let fixture: ComponentFixture<BuyAbonamentCancelledComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuyAbonamentCancelledComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuyAbonamentCancelledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
