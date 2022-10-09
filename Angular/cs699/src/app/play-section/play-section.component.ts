import { Component, OnInit } from '@angular/core';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-play-section',
  templateUrl: './play-section.component.html',
  styleUrls: ['./play-section.component.scss']
})
export class PlaySectionComponent implements OnInit {

  video: Video = new Video();
  videoUrl: String = '';

  constructor(private commonService: CommonService) { }

  ngOnInit(): void {
    this.video = this.commonService.getVideo();
    console.log(this.video);
    this.videoUrl = "data:video/mp4;base64," + this.video.data;
  }

}

