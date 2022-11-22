import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-edit-video-details',
  templateUrl: './edit-video-details.component.html',
  styleUrls: ['./edit-video-details.component.scss']
})
export class EditVideoDetailsComponent implements OnInit {

  constructor(private videoService: VideoService, private commonService: CommonService) { }

  video: Video = new Video();
  user: User;
  

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem('user'))
  }

  editVidDetails(){
    this.video.vidId = this.commonService.getVideoToBeEdited().vidId
    console.log(this.video);
    this.videoService.editVideo(this.video).subscribe(
      resp => {
        console.log("Successfully edited");
        location.reload();
      }
    )
  }

}
