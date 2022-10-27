import { Component, OnInit } from '@angular/core';
import { Video } from 'src/models/Video';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.scss']
})
export class UploadVideoComponent implements OnInit {

  video: Video = new Video();

  constructor() { }

  ngOnInit(): void {
  }

  public removeUser(){
    localStorage.removeItem('user');
  }

}
