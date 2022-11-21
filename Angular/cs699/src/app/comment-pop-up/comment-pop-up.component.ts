import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Comment1 } from 'src/models/Comment1';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-comment-pop-up',
  templateUrl: './comment-pop-up.component.html',
  styleUrls: ['./comment-pop-up.component.scss']
})
export class CommentPopUpComponent implements OnInit {

  user = JSON.parse(localStorage.getItem('user'));

  comment: Comment1 = new Comment1();
  video: Video;

  constructor(private commonService: CommonService, private videoService: VideoService) { }

  ngOnInit(): void {
  }

  submitComment(){
    this.video = this.commonService.getVideo();
    this.comment.commentorId = JSON.parse(localStorage.getItem('user')).userId;
    this.comment.vidId = this.video.vidId;
    console.log(this.comment);
    this.videoService.addCommentByUserSpringBoot(this.comment).subscribe(
      resp => {
        console.log(resp);
      }
    )
    
  }

}
