import { Component, OnInit } from '@angular/core';
import { PatientModel } from 'src/app/model/PatientModel';
import { PrescriptionMed} from '../model/prescriptionMedModel';
import * as $ from 'jquery';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  search: string;
  patientModel: PatientModel = {} as PatientModel;
  medModel: PrescriptionMed = {} as PrescriptionMed;
  constructor() {
   }
  ngOnInit() {
    this.patientModel.medicines = [];
  }
  delete(index) {
    this.patientModel.medicines.splice(index, 1);

  }
  onModalSubmit() {
     this.patientModel.medicines.push(this.medModel);
     $('#closebtn').click();
     this.medModel = {} as PrescriptionMed;
  }
  onSubmit() {
  }
  onSearchSubmit() {
    console.log(this.search);
    debugger;
  }
}
