import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { PlaySectionComponent } from './play-section/play-section.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path: '', pathMatch: "full", component: LoginComponent},
  {path: 'homepage', pathMatch: "full", component: HomepageComponent},
  {path: 'login',pathMatch: 'full', component: LoginComponent},
  {path: 'register', pathMatch: 'full', component: RegistrationComponent},
  {path: 'playSection/:vidId', pathMatch: 'full', component: PlaySectionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
