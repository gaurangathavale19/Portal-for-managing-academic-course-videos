import { Injectable } from '@angular/core';
import { Video } from 'src/models/Video';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  video: Video = new Video();

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


}
