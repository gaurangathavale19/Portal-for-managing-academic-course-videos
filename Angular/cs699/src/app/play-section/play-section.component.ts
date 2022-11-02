import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Like } from 'src/models/Like';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-play-section',
  templateUrl: './play-section.component.html',
  styleUrls: ['./play-section.component.scss']
})
export class PlaySectionComponent implements OnInit {

  video: Video = new Video();
  videoUrl: String = '';
  vidId: Number;
  like_dislike_icon = 'thumb_up'
  like: Like = new Like();

  constructor(private commonService: CommonService, private videoService: VideoService, private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('user')!=null){
    this.like.userId = JSON.parse(localStorage.getItem('user')).userId;
    this.like.vidId = parseInt(localStorage.getItem('video'));
    this.videoService.checkIfVidLikedByUserSpringBoot(this.like).subscribe(
      resp => {
        console.log(resp);
        if(resp !== 0){
          this.like_dislike_icon = 'thumb_down'
        }
      }
    )

    this.vidId = parseInt(this.videoService.getVideo());
    // console.log(this.video.data);
    this.videoService.getVideoByVideoIdSpringBoot(this.vidId).subscribe(
      resp => {
        this.video = resp;
        console.log(this.video);
        this.videoUrl = "data:video/mp4;base64," + this.video.data;
      }
    )

    
  
  }
  else{
    this.router.navigate(['/pageNotFound'])
  }
}


  ngOnChanges(): void {
    this.vidId = parseInt(this.videoService.getVideo());
    // console.log(this.video.data);
    this.videoService.getVideoByVideoIdSpringBoot(this.vidId).subscribe(
      resp => {
        this.video = resp;
        console.log(this.video);
        this.videoUrl = "data:video/mp4;base64," + this.video.data;
      }
    )
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

  likeVideo(vidId: Number) {

    console.log(this.like_dislike_icon);
    if(this.like_dislike_icon === 'thumb_up'){

      this.videoService.likeAVideoSpringBoot(vidId).subscribe(
        resp => {
          console.log(resp);
          this.videoService.getVideoByVideoIdSpringBoot(vidId).subscribe(
            resp => {
              this.video = resp;
              console.log(this.video);
            }
          )
        }
      )
      console.log(vidId);
      this.like.vidId = vidId;
      this.like.userId = JSON.parse(localStorage.getItem('user')).userId;
      console.log(this.like);

      this.videoService.addALikeSpringBoot(this.like).subscribe(
        resp => {
          console.log(resp);
        }
      )
      this.like_dislike_icon = 'thumb_down';
      this.video.likes = +this.video.likes + 1;
    }
    else {
      this.videoService.unlikeAVideoSpringBoot(vidId).subscribe(
        resp => {
          console.log(resp);
        }
      )
      this.like.vidId = vidId;
      this.like.userId = JSON.parse(localStorage.getItem('user')).userId;
      this.videoService.removeALikeSpringBoot(this.like).subscribe(
        resp => {
          console.log(resp);
        }
      )
      this.like_dislike_icon = 'thumb_up';
      this.video.likes = +this.video.likes - 1;
    }
  }

}
