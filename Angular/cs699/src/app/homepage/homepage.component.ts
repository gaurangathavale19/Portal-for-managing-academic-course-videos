import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  displayedColumns: String[] = ['SrNo', 'title', 'description', 'category', 'createdBy', 'play']

  dataSource: Video = null;
  video: Video = null;
  user: User = null;

  constructor(private videoService: VideoService, private loginSevice: LoginService, private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {
    this.videoService.getAllVideosSpringBoot().subscribe(
      resp => {
        this.video = resp;
        console.log(this.video[0]);
        console.log(this.video);
        this.dataSource = this.video;
        for (let i = 0; i < resp.length; i++){
          this.videoService.getCreatorNameFromCreatorIdSpringBoot(this.video[i].creator).subscribe(
            resp1 => {
              this.video[i].creatorName = resp1.userName;
              console.log(this.video);
              this.dataSource = this.video;
            }
          )
          
        }
      }
    )
  }

  public allVideos() {
    this.displayedColumns = ['SrNo', 'title', 'description', 'category', 'createdBy', 'play']
    this.dataSource = this.video;
    console.log(this.dataSource);
  }

  public myVideos(){
    this.user = JSON.parse(this.loginSevice.getUser());
    this.displayedColumns = ['SrNo', 'title', 'description', 'category', 'play']
    console.log(this.user);
    this.videoService.getMyVideosSpringBoot(this.user.userName).subscribe(
      resp => {
        this.dataSource = resp;
        console.log(this.dataSource);
      }
    );
  }

  public onPlay(vidId: Number){
    this.videoService.getVideoByVideoIdSpringBoot(vidId).subscribe(
      resp => {
        this.commonService.setVideo(resp);
        this.video = resp
        console.log(this.video);
        this.videoService.setVideo(vidId);
        this.router.navigate(['/playSection', vidId]);
      }
    );
  }

  public removeUser(){
    localStorage.removeItem('user');
  }

}
