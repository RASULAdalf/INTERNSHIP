import { Injectable } from '@angular/core';
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {StudentModalComponent} from "../components/student-modal/student-modal.component";
import {ProgramModalComponent} from "../components/program-modal/program-modal.component";

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  public studentDialogRef: MatDialogRef<StudentModalComponent, any> | undefined;
  public programDialogRef: MatDialogRef<ProgramModalComponent, any> | undefined;
  constructor(private modalService:MatDialog) { }

  public openStudentModal(index:any, data:any[]) {
    this.studentDialogRef = this.modalService.open(StudentModalComponent,{
      height: '620px',
      width: '750px',
      data:{
        index:index,
        data:data
      }
    });
  }
  public openProgramModal(index:any, data:any[]) {
    this.programDialogRef = this.modalService.open(ProgramModalComponent,{
      height: '620px',
      width: '750px',
      data:{
        index:index,
        data:data
      }
    });
  }
}
