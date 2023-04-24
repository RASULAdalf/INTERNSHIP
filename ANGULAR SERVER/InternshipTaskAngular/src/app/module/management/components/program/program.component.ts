import {Component, Input, OnInit} from '@angular/core';
import {ManagementService} from "../../services/management.service";
import {ModalService} from "../../services/modal.service";

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrls: ['./program.component.scss']
})
export class ProgramComponent implements OnInit {
  @Input() data : any;
  constructor(private modalService:ModalService) { }

  ngOnInit(): void {
  }

  openModal(viewButton: any) {
    this.modalService.openProgramModal(viewButton.getAttribute("data-index"),this.data);
  }
}
