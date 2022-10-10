import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-play-section',
  templateUrl: './play-section.component.html',
  styleUrls: ['./play-section.component.scss']
})
export class PlaySectionComponent implements OnInit {

  video: Video = new Video();
  videoUrl: String = '';

  constructor(private commonService: CommonService, private videoService: VideoService) { }

  ngOnInit(): void {
    this.video = this.commonService.getVideo();
    // console.log(this.video.data);
    this.videoUrl = "data:video/mp4;base64," + this.video.data;
  }

  @ViewChild("videoPlayer", { static: false }) videoplayer: ElementRef;
  isPlay: boolean = false;
  toggleVideo(event: any) {
    this.videoplayer.nativeElement.play();
  }
  playPause() {
    var myVideo: any = document.getElementById("video");
    if (myVideo.paused) myVideo.play();
    else myVideo.pause();
  }

  skip(value) {
    let video: any = document.getElementById("video");
    video.currentTime += value;
  }

  restart() {
    let video: any = document.getElementById("video");
    video.currentTime = 0;
  }

  like(vidId: Number) {
    this.videoService.likeAVideoSpringBoot(vidId).subscribe(
      resp => {
        this.video = resp;
        console.log(this.video);
      }
    )
  }

}
