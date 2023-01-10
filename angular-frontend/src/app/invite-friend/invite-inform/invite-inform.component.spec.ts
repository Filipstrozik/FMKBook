import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InviteInformComponent } from './invite-inform.component';

describe('InviteInformComponent', () => {
  let component: InviteInformComponent;
  let fixture: ComponentFixture<InviteInformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InviteInformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InviteInformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
