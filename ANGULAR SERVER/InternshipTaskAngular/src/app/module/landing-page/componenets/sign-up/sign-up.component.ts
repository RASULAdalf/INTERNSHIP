import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LandingPageOperationsService} from "../../services/landing-page-operations.service";
import {PasswordValidator} from "../../validators/PasswordValidator";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  SignUpDetailsForm = new FormGroup({
    email:new FormControl('',[Validators.required,Validators.email]),
    password:new FormControl('',[Validators.required,Validators.minLength(8)]),
    Repassword:new FormControl([''],[Validators.required,PasswordValidator('password')])
  });
  constructor(private landingPageOperationsService:LandingPageOperationsService) { }

  ngOnInit(): void {
  }

  SignUp() {
    this.landingPageOperationsService.signUp(this.SignUpDetailsForm.get('email')?.value.toString(),this.SignUpDetailsForm.get('password')?.value.toString());
  }

  SignUpWithGoogle() {
    this.landingPageOperationsService.signUpWithGoogle();
  }
}
