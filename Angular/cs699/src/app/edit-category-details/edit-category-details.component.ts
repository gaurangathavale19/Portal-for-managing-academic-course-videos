import { Component, OnInit } from '@angular/core';
import { Category } from 'src/models/Category';
import { User } from 'src/models/User';
import { CommonService } from '../service/common.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-edit-category-details',
  templateUrl: './edit-category-details.component.html',
  styleUrls: ['./edit-category-details.component.scss']
})
export class EditCategoryDetailsComponent implements OnInit {

  category: Category = new Category();
  user: User;

  constructor(private commonService: CommonService, private videoService: VideoService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('user'));
  }

  public editCategoryDetails(){
    this.category.catId = this.commonService.getCategoryToBeEdited().catId
    console.log(this.category);
    this.videoService.editCategory(this.category).subscribe(
      resp => {
        console.log("Successfully edited");
        location.reload();
      }
    )
  }

}
