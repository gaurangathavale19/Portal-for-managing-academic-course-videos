import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment1 } from 'src/models/Comment1';
import { Like } from 'src/models/Like';
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

  public unlikeAVideoSpringBoot(vidId: Number): Observable<any>{
    return this.http.put(this.BASEURL + '/unlikeAVideo/', vidId);
  }

  public uploadVideoDetails(video: any): Observable<any>{
    return this.http.post(this.BASEURL + '/saveVideo', video);
  }

  public addALikeSpringBoot(like: Like): Observable<any>{
    return this.http.post(this.BASEURL + '/addALike', like);
  }

  public removeALikeSpringBoot(like: Like): Observable<any>{
    return this.http.put(this.BASEURL + '/removeALike', like);
  }

  public checkIfVidLikedByUserSpringBoot(like: Like): Observable<any>{
    return this.http.get(this.BASEURL + '/checkIfVidLikedByUser/' + like.userId + '/' + like.vidId);
  }

  public addCommentByUserSpringBoot(comment: Comment1): Observable<any>{
    return this.http.post(this.BASEURL + '/addComment', comment);
  }

  public getAllCommentsByVidIdSpringBoot(vidId: Number): Observable<any>{
    return this.http.get(this.BASEURL + '/getCommentByVidId/' + vidId);
  }

  public getAllCategoriesSpringBoot(): Observable<any>{
    return this.http.get(this.BASEURL + '/getAllCategories/');
  }

  public getCategoryNameFromCategoryIdSpringBoot(categoryId: Number): Observable<any>{
    return this.http.get(this.BASEURL + '/getCategoryNameFromCategoryId/' + categoryId);
  }

  public getAllPendingVideosSpringBoot(): Observable<any>{
    return this.http.get(this.BASEURL + '/pending');
  }

  public editVideo(video: Video): Observable<any>{
    return this.http.post(this.BASEURL + '/editVideo', video);
  }

  public deleteVideo(video: Video): Observable<any>{
    return this.http.post(this.BASEURL + '/deleteVideo', video);
  }

}
