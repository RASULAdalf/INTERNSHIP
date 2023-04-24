import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ManagementRoutingModule } from './management-routing.module';
import { ManagementComponent } from './management.component';
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import { StudentComponent } from './components/student/student.component';
import { ProgramComponent } from './components/program/program.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import { StudentModalComponent } from './components/student-modal/student-modal.component';
import { ProgramModalComponent } from './components/program-modal/program-modal.component';
import { AddNewStudentModalComponent } from './components/add-new-student-modal/add-new-student-modal.component';
import { AddNewProgramComponent } from './components/add-new-program/add-new-program.component';
import {MatDialogModule} from "@angular/material/dialog";


@NgModule({
  declarations: [
    ManagementComponent,
    StudentComponent,
    ProgramComponent,
    StudentModalComponent,
    ProgramModalComponent,
    AddNewStudentModalComponent,
    AddNewProgramComponent
  ],
    imports: [
        CommonModule,
        ManagementRoutingModule,
        MatButtonModule,
        MatIconModule,
        MatPaginatorModule,
        MatInputModule,
        ReactiveFormsModule,
        MatDialogModule
    ]
})
export class ManagementModule { }
