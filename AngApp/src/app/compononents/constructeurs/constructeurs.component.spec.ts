import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstructeursComponent } from './constructeurs.component';

describe('ConstructeursComponent', () => {
  let component: ConstructeursComponent;
  let fixture: ComponentFixture<ConstructeursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConstructeursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConstructeursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
