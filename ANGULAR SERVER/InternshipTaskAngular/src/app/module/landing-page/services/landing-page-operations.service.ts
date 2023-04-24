import { Injectable } from '@angular/core';
import {LoginService} from "../../../service/login.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LandingPageOperationsService {

  constructor(private loginService:LoginService,private router:Router) { }

  signUp(email: any, password: any) {
    this.loginService.SignUp(email,password).then(res=>{
      console.log(res);
    },error=>{
      console.log(error)})
  }

  signUpWithGoogle() {
    this.loginService.GoogleAuth().then(res=>{
      this.router.navigate(['/management'])
    },error=>{
      //error
    });

  }

  signIn(email: any, password: any) {
    this.loginService.SignIn(email,password).then(res=>{
      this.router.navigate(['/management'])
    },error=>{
      //error
    });
  }

  signInWithGoogle() {
    this.loginService.GoogleAuth().then(res=>{

      this.router.navigate(['/management'])
    },error=>{
      //error
    });
  }
}
