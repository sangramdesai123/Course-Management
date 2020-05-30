import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TranningmatrialComponent } from './tranningmatrial.component';

describe('TranningmatrialComponent', () => {
  let component: TranningmatrialComponent;
  let fixture: ComponentFixture<TranningmatrialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TranningmatrialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TranningmatrialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
