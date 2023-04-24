import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PasswordValidator} from "../../validators/PasswordValidator";
import {LandingPageOperationsService} from "../../services/landing-page-operations.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  SignInDetailsForm = new FormGroup({
    email:new FormControl('',[Validators.required,Validators.email]),
    password:new FormControl('',[Validators.required,Validators.minLength(8)]),
  });
  constructor(private landingPageOperationsService:LandingPageOperationsService) { }

  ngOnInit(): void {
  }

  SignIn() {
    this.landingPageOperationsService.signIn(this.SignInDetailsForm.get('email')?.value.toString(),this.SignInDetailsForm.get('password')?.value.toString());
  }

  SignInWithGoogle() {
    this.landingPageOperationsService.signInWithGoogle();
  }



}
