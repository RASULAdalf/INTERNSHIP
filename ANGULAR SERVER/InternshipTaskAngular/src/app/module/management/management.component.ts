import { Component, OnInit } from '@angular/core';
import {PageEvent} from "@angular/material/paginator";
import {FormControl, FormGroup} from "@angular/forms";
import {debounceTime} from "rxjs";
import {ManagementService} from "./services/management.service";

@Component({
  selector: 'app-management',
  templateUrl: './management.component.html',
  styleUrls: ['./management.component.scss']
})
export class ManagementComponent implements OnInit {
  page:number | undefined=0;
  pageSize:number | undefined=6;
  pageSizeOptions=[10,20,30,40];//The number of data which can be loaded inside one page
  pageEvent:PageEvent | undefined;

  private searchText: any="";
  public year: number;
  StudentsSearchForm = new FormGroup({
    searchText:new FormControl('')
  });
  ProgramsSearchForm = new FormGroup({
    searchText:new FormControl('')
  });


  constructor(public managementService:ManagementService) {
    this.year = new Date().getFullYear();

    // Form Listeners
    this.StudentsSearchForm.valueChanges.pipe(debounceTime(1080)).subscribe(data=>{
      //This 1080 is a debounceTime, means that to make a request to the server only if the user has stopped typing for a second rather than making requests to the server whenever the user types something
      this.searchText = data.searchText;
      this.managementService.loadStudentsServerData(this.searchText,this.page,this.pageSize);
    });
    this.ProgramsSearchForm.valueChanges.pipe(debounceTime(1080)).subscribe(data=>{
      //This 1080 is a debounceTime, means that to make a request to the server only if the user has stopped typing for a second rather than making requests to the server whenever the user types something
      this.searchText = data.searchText;
      this.managementService.loadProgramsServerData(this.searchText,this.page,this.pageSize);
    });

  }

  ngOnInit(): void {
    this.managementService.loadStudentsServerData(this.searchText,this.page,this.pageSize);
    this.managementService.loadProgramsServerData(this.searchText,this.page,this.pageSize);
  }

  logout() {

  }

  loadProgramsData(event:PageEvent):any {
    // @ts-ignore
    this.page = event?.pageIndex;
    // @ts-ignore
    this.pageSize = event?.pageSize;
    this.managementService.loadProgramsServerData(this.searchText,this.page,this.pageSize);

  }

  loadStudentsData(event: PageEvent):any {
    this.page = event?.pageIndex;
    // @ts-ignore
    this.pageSize = event?.pageSize;
    this.managementService.loadStudentsServerData(this.searchText,this.page,this.pageSize);


  }
}
