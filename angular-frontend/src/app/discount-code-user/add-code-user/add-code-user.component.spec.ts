import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCodeUserComponent } from './add-code-user.component';

describe('AddCodeUserComponent', () => {
  let component: AddCodeUserComponent;
  let fixture: ComponentFixture<AddCodeUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCodeUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCodeUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
