import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { CommonService } from 'src/app/service/common.service';

@Component({
  selector: 'app-patient-history',
  templateUrl: './patient-history.component.html',
  styleUrls: ['./patient-history.component.css']
})
export class PatientHistoryComponent implements OnInit {
  patient: Patient = {} as Patient;
  constructor(private commonService: CommonService) {
   }

  ngOnInit() {
      this.commonService.getPatientHistory(this.patient.id).subscribe((data) => {
          debugger;
      });
  }

}
