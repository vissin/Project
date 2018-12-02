import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';

import { ChemistComponent } from 'src/app/chemist/chemist.component';
import { PatientHistoryComponent } from './patient-history/patient-history.component';
import { AuthGuard } from 'src/app/service/auth.guard';

// const routes: Routes = [
//   { path: '', redirectTo: '/login', pathMatch: 'full' },
//   { path: 'login', component: LoginComponent},
//   {path: 'patient', component: PatientComponent},
//   {path: 'doctor', component: DoctorComponent}
// ];



const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'patient/:id',
    component: PatientComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'chemist/:id',
    component: ChemistComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'doctor/:id',
    component: DoctorComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'patient-history/:id',
    component: PatientHistoryComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
