import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ManagementGuard} from "./module/management/guards/management.guard";

const routes: Routes = [{ path: 'landing', loadChildren: () => import('./module/landing-page/landing-page.module').then(m => m.LandingPageModule) },{path:'',redirectTo:'/landing',pathMatch:'full'}, { path: 'management',canActivate:[ManagementGuard], loadChildren: () => import('./module/management/management.module').then(m => m.ManagementModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
