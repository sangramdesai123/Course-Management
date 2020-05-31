import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmatrialComponent } from './addmatrial.component';

describe('AddmatrialComponent', () => {
  let component: AddmatrialComponent;
  let fixture: ComponentFixture<AddmatrialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmatrialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmatrialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
