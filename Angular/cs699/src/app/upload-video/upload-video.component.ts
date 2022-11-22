import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/models/Category';
import { User } from 'src/models/User';
import { Video } from 'src/models/Video';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.scss']
})
export class UploadVideoComponent implements OnInit {

  video: Video = new Video();
  videoStatus = '';
  fileChosenName = 'No file chosen';
  uploadedFile: File;
  category: Category = new Category();
  categories: Array<Category> = [];
  catId: Number;
  user: User;

  constructor(private httpClient: HttpClient, private videoService: VideoService, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {

    this.user = JSON.parse(this.loginService.getUser());

    this.videoService.getAllCategoriesSpringBoot().subscribe(
      resp => {
          this.categories = resp;
          console.log(this.categories);
      }
    )
  }

  public removeUser(){
    localStorage.removeItem('user');
  }

  public onSelectionOfFile(event){
    this.uploadedFile = event.target.files[0];
    this.fileChosenName = event.target.files[0].name;
    console.log(this.uploadedFile)
  } 

  public uploadVideo(){
    const videoData = new FormData();
    videoData.append('videoFile', this.uploadedFile, this.fileChosenName);
    this.httpClient.post('http://localhost:8080/uploadVideo', videoData, {observe: 'response'})
    .subscribe((resp) => {
      // console.log(resp.body.id);
      if (resp.statusText === "OK") {
        let uploadedVideo:any = resp.body;
        this.video.vidId = uploadedVideo.vidId;
        console.log(uploadedVideo);
        this.videoStatus = 'Video uploaded successfully now press the save button.';
      } else {
        this.videoStatus = 'Video not uploaded successfully';
      }
      this.video.creator = JSON.parse(localStorage.getItem('user')).userId;
      this.categories.forEach(cat => {
        if(this.catId == cat.catId){
          this.video.categoryId = this.catId;
        }
      })
      this.videoService.uploadVideoDetails(this.video).subscribe(
        resp => {
          console.log(this.video);
          console.log(resp);
        }
      )

    })

    this.router.navigate(['/homepage']);

  }

  public goToManagePage(){
    this.router.navigate(['/manageVideos'])
  }

  public goToAddCategoryPage(){
    this.router.navigate(['/manageCategory'])
  }

}
