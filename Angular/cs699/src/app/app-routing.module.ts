import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorPageComponent } from './error-page/error-page.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ManageVideosComponent } from './manage-videos/manage-videos.component';
import { PlaySectionComponent } from './play-section/play-section.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';

const routes: Routes = [
  {path: '', pathMatch: "full", component: LoginComponent},
  {path: 'homepage', pathMatch: "full", component: HomepageComponent},
  {path: 'login',pathMatch: 'full', component: LoginComponent},
  {path: 'register', pathMatch: 'full', component: RegistrationComponent},
  {path: 'playSection/:vidId', pathMatch: 'full', component: PlaySectionComponent},
  {path: 'uploadVideo', pathMatch: 'full', component: UploadVideoComponent},
  {path: 'pageNotFound', pathMatch: 'full', component: ErrorPageComponent},
  {path: 'manageVideos', pathMatch: 'full', component: ManageVideosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
