import { TestBed } from '@angular/core/testing';

import { TypAbonamentuService } from './typ-abonamentu.service';

describe('TypAbonamentuService', () => {
  let service: TypAbonamentuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypAbonamentuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
