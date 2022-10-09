import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  BASEURL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  public getAllVideosSpringBoot(): Observable<any>{
    return this.http.get(this.BASEURL + '/allVideos');
  }

  public getMyVideosSpringBoot(userName: String): Observable<any>{
    return this.http.get(this.BASEURL + '/myVideos/' + userName);
  }

  public getVideoByVideoIdSpringBoot(vidId: Number): Observable<any>{
    return this.http.get(this.BASEURL+'/videoByVidId/' + vidId);
  }

}
