import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';

import { ChemistComponent } from 'src/app/chemist/chemist.component';

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
    component: PatientComponent
  },
  {
    path: 'chemist/:id',
    component: ChemistComponent
  },
  {
    path: 'doctor/:id',
    component: DoctorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
