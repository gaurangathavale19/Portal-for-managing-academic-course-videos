import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaySectionComponent } from './play-section.component';

describe('PlaySectionComponent', () => {
  let component: PlaySectionComponent;
  let fixture: ComponentFixture<PlaySectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaySectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlaySectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
