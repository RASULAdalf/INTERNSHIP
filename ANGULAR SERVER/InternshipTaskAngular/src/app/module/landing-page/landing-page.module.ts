import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LandingPageRoutingModule } from './landing-page-routing.module';
import { LandingPageComponent } from './landing-page.component';
import {MatButtonModule} from "@angular/material/button";
import {MatTabsModule} from "@angular/material/tabs";
import { SignUpComponent } from './componenets/sign-up/sign-up.component';
import { LoginComponent } from './componenets/login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    LandingPageComponent,
    SignUpComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    LandingPageRoutingModule,
    MatButtonModule,
    MatTabsModule,
    ReactiveFormsModule,
    MatInputModule
  ]
})
export class LandingPageModule { }
