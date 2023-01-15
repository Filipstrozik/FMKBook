import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyAbonamentConfirmedComponent } from './buy-abonament-confirmed.component';

describe('BuyAbonamentConfirmedComponent', () => {
  let component: BuyAbonamentConfirmedComponent;
  let fixture: ComponentFixture<BuyAbonamentConfirmedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuyAbonamentConfirmedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuyAbonamentConfirmedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
