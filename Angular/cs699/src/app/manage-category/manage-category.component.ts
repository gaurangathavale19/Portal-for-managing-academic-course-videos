import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Category } from 'src/models/Category';
import { User } from 'src/models/User';
import { AddCategoryComponent } from '../add-category/add-category.component';
import { EditCategoryDetailsComponent } from '../edit-category-details/edit-category-details.component';
import { CommonService } from '../service/common.service';
import { LoginService } from '../service/login.service';
import { VideoService } from '../service/video.service';

@Component({
  selector: 'app-manage-category',
  templateUrl: './manage-category.component.html',
  styleUrls: ['./manage-category.component.scss']
})
export class ManageCategoryComponent implements OnInit {

  displayedColumns: String[] = ['SrNo', 'name', 'edit', 'delete']
  category = new Category();
  dataSource: Category = null;
  vidId: Number;
  categoryName: Number;
  user: User;

  constructor(private videoService: VideoService, private dialog: MatDialog, private commonService: CommonService, private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(this.loginService.getUser());
    this.videoService.getAllCategoriesSpringBoot().subscribe(
      resp => {
        this.dataSource = resp;
        console.log(this.dataSource);
      }
    )
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

  public openEditDialog(element){
    const dialogRef = this.dialog.open(EditCategoryDetailsComponent, {
      width: '250px',
      data: {categoryName: this.categoryName, vidId: this.vidId}
    })

    this.commonService.setCategoryToBeEdited(element);

    dialogRef.afterClosed().subscribe(resp => {
      this.categoryName = resp;
      dialogRef.close();
    });
  }

  public openAddDialog(){
    const dialogRef = this.dialog.open(AddCategoryComponent, {
      width: '250px',
      data: {categoryName: this.categoryName}
    })

    // this.commonService.setCategoryToBeEdited(element);

    dialogRef.afterClosed().subscribe(resp => {
      this.categoryName = resp;
      dialogRef.close();
    });
  }

  public deleteCategory(category){
    this.videoService.deleteCategory(category).subscribe(
      resp => {
        console.log("deleted successfully");
        location.reload();
      }
    )
  }

}
