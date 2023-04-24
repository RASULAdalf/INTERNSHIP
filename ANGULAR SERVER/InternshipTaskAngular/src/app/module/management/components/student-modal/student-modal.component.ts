import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-student-modal',
  templateUrl: './student-modal.component.html',
  styleUrls: ['./student-modal.component.scss']
})
export class StudentModalComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<StudentModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { index:any,data:any[]}
  ) { }

  ngOnInit(): void {
  }

}
