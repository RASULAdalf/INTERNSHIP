import {Component, Input, OnInit} from '@angular/core';
import {ModalService} from "../../services/modal.service";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  @Input() data : any;
  constructor(private modalService:ModalService) { }

  ngOnInit(): void {
  }

  openModal(viewButton: any) {
    this.modalService.openStudentModal(viewButton.getAttribute("data-index"),this.data);
  }
}
