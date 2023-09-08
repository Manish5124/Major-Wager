import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolljobComponent } from './enrolljob.component';

describe('EnrolljobComponent', () => {
  let component: EnrolljobComponent;
  let fixture: ComponentFixture<EnrolljobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnrolljobComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnrolljobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
