import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { EditVideoDetailsComponent } from '../edit-video-details/edit-video-details.component';
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
  // allVideosButton = 'mat-stroked-button'
  dataSource: Video = null;
  video: Video = null;
  user: User = null;
  vidName: String;
  vidDescription: String;
  vidId: Number;

  constructor(private videoService: VideoService, private loginSevice: LoginService, private commonService: CommonService, private router: Router, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.user = JSON.parse(this.loginSevice.getUser());
    console.log(this.user.admin);
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

  public allVideos() {
    this.displayedColumns = ['SrNo', 'title', 'description', 'category', 'createdBy', 'play']
    this.dataSource = this.video;
    console.log(this.dataSource);
  }

  public myVideos(){
    this.user = JSON.parse(this.loginSevice.getUser());
    this.displayedColumns = ['SrNo', 'title', 'description', 'category', 'status', 'play', 'edit', 'delete']
    console.log(this.user);
    this.videoService.getMyVideosSpringBoot(this.user.userName).subscribe(
      resp => {
        this.dataSource = resp;
        console.log(this.dataSource);
        for (let j = 0; j < resp.length; j++){
          console.log(resp[j].categoryId);
          this.videoService.getCategoryNameFromCategoryIdSpringBoot(resp[j].categoryId).subscribe(
            resp2 => {
              console.log(resp2)
              resp[j].categoryName = resp2.categoryName;
              resp[j].vidShortDescription = resp[j].vidDescription;
              resp[j].creatorName = this.user.userName;
              if(resp[j].vidDescription.length > 20){
                resp[j].vidShortDescription = resp[j].vidDescription.slice(0,20)+'......'
              }
              console.log(resp);
              this.dataSource = resp;
            }
          )
        }
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

  public goToUploadPage(){
    this.router.navigate(['/uploadVideo']);
  }

  public goToManagePage(){
    this.router.navigate(['/manageVideos'])
  }

  public goToAddCategoryPage(){
    this.router.navigate(['/manageCategory'])
  }

  public openEditDialog(element){
    const dialogRef = this.dialog.open(EditVideoDetailsComponent, {
      width: '250px',
      data: {vidName: this.vidName, vidDescription: this.vidDescription, vidId: this.vidId}
    })

    this.commonService.setVideoToBeEdited(element);

    dialogRef.afterClosed().subscribe(resp => {
      this.vidName = resp;
    });

  }

  public deleteVideo(video){
    this.videoService.deleteVideo(video).subscribe(
      resp => {
        console.log("deleted successfully");
        location.reload();
      }
    )
  }

}
