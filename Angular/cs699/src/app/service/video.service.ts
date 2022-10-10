import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Video } from 'src/models/Video';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  BASEURL = "http://localhost:8080";

  constructor(private http: HttpClient) { }


  public setVideo(vidId: Number){
    localStorage.setItem('video',JSON.stringify(vidId));
  }

  public getVideo(){
    return localStorage.getItem('video');
  }

  public getAllVideosSpringBoot(): Observable<any>{
    return this.http.get(this.BASEURL + '/allVideos');
  }

  public getMyVideosSpringBoot(userName: String): Observable<any>{
    return this.http.get(this.BASEURL + '/myVideos/' + userName);
  }

  public getVideoByVideoIdSpringBoot(vidId: Number): Observable<any>{
    return this.http.get(this.BASEURL+'/videoByVidId/' + vidId);
  }

  public getCreatorNameFromCreatorIdSpringBoot(creatorId: Number): Observable<any>{
    return this.http.get(this.BASEURL+'/getCreatorNameFromCreatorId/' + creatorId);
  }

  public likeAVideoSpringBoot(vidId: Number): Observable<any>{
    return this.http.put(this.BASEURL + '/likeAVideo/', vidId);
  }

}
