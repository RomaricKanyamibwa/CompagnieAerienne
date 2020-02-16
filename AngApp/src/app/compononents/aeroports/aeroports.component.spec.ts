import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AeroportsComponent } from './aeroports.component';

describe('AeroportsComponent', () => {
  let component: AeroportsComponent;
  let fixture: ComponentFixture<AeroportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AeroportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AeroportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
