import { TestBed } from '@angular/core/testing';

import { RabatService } from './rabat.service';

describe('RabatService', () => {
  let service: RabatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RabatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
