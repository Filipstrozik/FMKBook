import { TestBed } from '@angular/core/testing';

import { MiejsceService } from './miejsce.service';

describe('MiejsceService', () => {
  let service: MiejsceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MiejsceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
