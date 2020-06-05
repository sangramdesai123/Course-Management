import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule,HttpTestingController } from '@angular/common/http/testing';
import { AddcourseComponent } from './addcourse.component';
import { RouterTestingModule } from '@angular/router/testing';
describe('AddcourseComponent', () => {
  let component: AddcourseComponent;
  let fixture: ComponentFixture<AddcourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AddcourseComponent],
      imports: [HttpClientTestingModule,RouterTestingModule]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
