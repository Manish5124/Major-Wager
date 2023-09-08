import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofjobComponent } from './listofjob.component';

describe('ListofjobComponent', () => {
  let component: ListofjobComponent;
  let fixture: ComponentFixture<ListofjobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListofjobComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListofjobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
