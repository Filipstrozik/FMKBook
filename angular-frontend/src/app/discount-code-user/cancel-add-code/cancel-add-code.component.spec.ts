import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelAddCodeComponent } from './cancel-add-code.component';

describe('CancelAddCodeComponent', () => {
  let component: CancelAddCodeComponent;
  let fixture: ComponentFixture<CancelAddCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CancelAddCodeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CancelAddCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
