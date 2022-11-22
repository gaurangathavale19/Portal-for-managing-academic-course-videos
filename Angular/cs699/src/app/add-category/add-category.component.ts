import { Component, OnInit } from '@angular/core';
import { Category } from 'src/models/Category';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.scss']
})
export class AddCategoryComponent implements OnInit {

  category = new Category();

  constructor(private videoService: VideoService) { }

  ngOnInit(): void {
  }

  public addCategory(){
    this.videoService.addCategory(this.category).subscribe(
      resp => {
        console.log(this.category);
        location.reload();
      }
    )
  }

}
