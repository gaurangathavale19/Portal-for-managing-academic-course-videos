import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { CommonService } from '../service/common.service';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-manage-videos',
  templateUrl: './manage-videos.component.html',
  styleUrls: ['./manage-videos.component.scss']
})
export class ManageVideosComponent implements OnInit {

  displayedColumns: String[] = ['SrNo', 'title', 'description', 'category', 'createdBy', 'play', 'approve', 'reject']
  dataSource: Video = null;
  video: Video = null;

  constructor(private videoService: VideoService, private loginService: LoginService, private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {
    this.videoService.getAllPendingVideosSpringBoot().subscribe(
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
              // this.dataSource = this.video;
            }
          )
        }
        for (let j = 0; j < resp.length; j++){
          console.log(this.video[j].categoryId);
          this.videoService.getCategoryNameFromCategoryIdSpringBoot(this.video[j].categoryId).subscribe(
            resp2 => {
              this.video[j].categoryName = resp2.categoryName;
              this.video[j].vidShortDescription = this.video[j].vidDescription;
              if(this.video[j].vidDescription.length > 20){
                this.video[j].vidShortDescription = this.video[j].vidDescription.slice(0,20)+'...'
              }
              this.dataSource = this.video
              console.log(this.dataSource);
            }
          )
        }
      }
    )
  }

  public removeUser(){
    localStorage.removeItem('user');
  }

  public goToUploadPage(){
    this.router.navigate(['/uploadVideo']);
  }


}
