import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyAbonamentListComponent } from './buy-abonament-list.component';

describe('BuyAbonamentListComponent', () => {
  let component: BuyAbonamentListComponent;
  let fixture: ComponentFixture<BuyAbonamentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuyAbonamentListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuyAbonamentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
