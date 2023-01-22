import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaMiejscaComponent } from './sala-miejsca.component';

describe('SalaMiejscaComponent', () => {
  let component: SalaMiejscaComponent;
  let fixture: ComponentFixture<SalaMiejscaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalaMiejscaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalaMiejscaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
