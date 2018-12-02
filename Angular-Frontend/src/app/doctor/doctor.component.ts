import { Component, OnInit } from '@angular/core';
import { PatientModel } from 'src/app/model/PatientModel';
import { PrescriptionMed} from '../model/prescriptionMedModel';
import { CommonService } from 'src/app/service/common.service';
import * as $ from 'jquery';
import { Patient } from '../model/patient';
import { ActivatedRoute, Params } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  search: string;
  patientModel: PatientModel = {} as PatientModel;
  medModel: PrescriptionMed = {} as PrescriptionMed;
  patient: Patient = {} as Patient;

  constructor(private commonService: CommonService, private route: ActivatedRoute,private router: Router) {
   }
  ngOnInit() {
    this.patientModel.medicine = [];
  }
  delete(index) {
    this.patientModel.medicine.splice(index, 1);

  }
  onModalSubmit() {
     this.patientModel.medicine.push(this.medModel);
     $('#closebtn').click();
     this.medModel = {} as PrescriptionMed;
  }
  gotoPatientHistory(){
    debugger;
    this.router.navigate(['patient-history', this.patient.id]);
  }
  onSubmit() {
    debugger;
    this.patientModel.patientId = this.patient.id;
    this.route.params.subscribe((params: Params) => {
    this.patientModel.doctorId = params['id'];
    });
    console.log(this.patientModel);
    this.commonService.addPatientDetails(this.patientModel).subscribe((data) => {
      if (data === true) {
        debugger;
        window.alert('Details has been added succesfully');
         this.patient.name = null;
         this.patientModel = null;
         this.search = null;
      } else {
        window.alert('Some error has occured');
      }
    });
  }
  onSearchSubmit() {
    console.log(this.search);
    this.commonService.getPatientbyIdOnSearch(this.search).subscribe(
      (data) => {
        this.patient = <Patient>data;
        debugger;
        if (this.patient.name != null) {
        } else{
           window.alert('Patient Not Found');
        }
      });
  }
}
