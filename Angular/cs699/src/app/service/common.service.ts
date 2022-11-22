import { Injectable } from '@angular/core';
import { Category } from 'src/models/Category';
import { Video } from 'src/models/Video';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  video: Video = new Video();
  category: Category = new Category();

  constructor() { }

  public setVideo(video: Video){
    this.video = video;
  }

  public getVideo(){
    return this.video;
  }

  public setVideoToBeEdited(video: Video){
    this.video = video;
  }

  public getVideoToBeEdited(){
    return this.video;
  }

  public setCategoryToBeEdited(category: Category){
    this.category = category;
  }

  public getCategoryToBeEdited(){
    return this.category;
  }


}
