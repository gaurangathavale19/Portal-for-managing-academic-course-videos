import { Component, ElementRef, OnInit, ViewChild, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Comment1 } from 'src/models/Comment1';
import { Like } from 'src/models/Like';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { CommentPopUpComponent } from '../comment-pop-up/comment-pop-up.component';
import { CommonService } from '../service/common.service';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-play-section',
  templateUrl: './play-section.component.html',
  styleUrls: ['./play-section.component.scss']
})
export class PlaySectionComponent implements OnInit {

  video: Video = new Video();
  videoUrl: String = '';
  vidId: Number;
  like_button_choice = 'material-icons-outlined'
  like: Like = new Like();
  commentString: string;
  name: string;
  comments: Comment1[];
  user: User;
  categoryName: String;

  constructor(private commonService: CommonService, private videoService: VideoService, private loginService: LoginService, private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.user = JSON.parse(this.loginService.getUser());

    if(localStorage.getItem('user')!=null){
    this.like.userId = JSON.parse(localStorage.getItem('user')).userId;
    this.like.vidId = parseInt(localStorage.getItem('video'));
    this.videoService.checkIfVidLikedByUserSpringBoot(this.like).subscribe(
      resp => {
        console.log(resp);
        if(resp !== 0){
          this.like_button_choice = ''
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


   

    this.videoService.getAllCommentsByVidIdSpringBoot(this.vidId).subscribe(
    resp => {
        this.comments = resp;
        for (let i = 0; i<this.comments.length; i++){
          this.videoService.getCreatorNameFromCreatorIdSpringBoot(this.comments[i].commentorId).subscribe(
            resp1 => {
              this.comments[i].commentorName = resp1.userName;
            }
          )
        }
    })

    
  
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

    console.log(this.like_button_choice);
    if(this.like_button_choice === 'material-icons-outlined'){

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
      this.like_button_choice = '';
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
      this.like_button_choice = 'material-icons-outlined';
      this.video.likes = +this.video.likes - 1;
    }
  }

  openDialog(video: Video): void {
    const dialogRef = this.dialog.open(CommentPopUpComponent, {
      width: '250px',
      data: {vidId: video.vidId}
    });
    
    this.commonService.setVideo(video);

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.commentString = result;
    });
  }

  public removeUser(){
    localStorage.removeItem('user');
  }

  public goToUploadPage(){
    this.router.navigate(['/uploadVideo']);
  }

  public goToManagePage(){
  this.router.navigate(['/manageVideos'])
  }

  public goToAddCategoryPage(){
    this.router.navigate(['/manageCategory'])
  }

}
