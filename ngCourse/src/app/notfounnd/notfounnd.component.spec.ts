import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotfounndComponent } from './notfounnd.component';

describe('NotfounndComponent', () => {
  let component: NotfounndComponent;
  let fixture: ComponentFixture<NotfounndComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotfounndComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotfounndComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
