import { Component, OnInit } from '@angular/core';
import { LoginModel } from 'src/app/model/loginModel';
import { CommonService } from 'src/app/service/common.service';
import { Doctor } from 'src/app/model/doctor';
import { Chemist } from 'src/app/model/chemist';
import { Patient } from 'src/app/model/patient';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel = {} as LoginModel;
  doctor: Doctor = {} as Doctor;
  chemist: Chemist = {} as Chemist;
  patient: Patient = {} as Patient;
  role = 'P';

  constructor(private commonService: CommonService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.commonService.userLogin(this.loginModel).subscribe(
      (data) => {
        if (data.result === 'Success') {
          localStorage.setItem('token', data.userId);
          switch (data.role) {
            case 'D': {
              this.doctor = data.doctor;
              this.router.navigate(['doctor', this.doctor.id]);
              break;
            }

            case 'P': {
              this.patient = data.patient;
              this.router.navigate(['patient', this.patient.id]);
              break;
            }

            case 'C': {
              this.chemist = data.chemist;
              this.router.navigate(['chemist', this.chemist.id]);
              break;
            }
          }
        }
      }
    );
  }

}
