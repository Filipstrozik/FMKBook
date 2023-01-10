import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvalidCodeUserComponent } from './invalid-code-user.component';

describe('InvalidCodeUserComponent', () => {
  let component: InvalidCodeUserComponent;
  let fixture: ComponentFixture<InvalidCodeUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvalidCodeUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvalidCodeUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
