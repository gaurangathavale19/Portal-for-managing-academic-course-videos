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
        this.dataSource = this.video;
        console.log(this.dataSource);
      }
    )
  }

  public allVideos() {
    this.dataSource = this.video;
    console.log(this.dataSource);
  }

  public myVideos(){
    this.user = JSON.parse(this.loginSevice.getUser());
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
        this.router.navigate(['/playSection', vidId]);
      }
    );
  }

}
