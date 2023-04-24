import { Injectable } from '@angular/core';
import {HttpService} from "../../../service/http.service";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ManagementService {
  public dataListStudent:any[] = [];
  public dataCountStudent:number=0;
  public dataListProgram:any[] = [];
  public dataCountProgram:number=0;
  private baseUrl = environment.DatabaseServerUrl;
  constructor(private httpService:HttpService) { }

  loadStudentsServerData(searchText: any, page: number | undefined, pageSize: number | undefined) {
      this.httpService.get(this.baseUrl+"student/list?searchText="+searchText+"&page="+page+"&size="+pageSize).subscribe(data=>{
      this.dataListStudent = data?.data?.list;
      this.dataCountStudent = data?.data?.dataCount;
    })
    console.log(this.dataListStudent);

  }

  loadProgramsServerData(searchText: any, page: number | undefined, pageSize: number | undefined) {
    this.httpService.get(this.baseUrl+"program/list?searchText="+searchText+"&page="+page+"&size="+pageSize).subscribe(data=>{
      this.dataListProgram = data?.data?.list;
      this.dataCountProgram = data?.data?.dataCount;
    })
    console.log(this.dataCountProgram);

  }
}
