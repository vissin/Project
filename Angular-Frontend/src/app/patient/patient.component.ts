import { Component, OnInit } from '@angular/core';
import { isNullOrUndefined } from 'util';
import { ActivatedRoute, Params } from '@angular/router';
import { CommonService } from 'src/app/service/common.service';
import { Patient } from 'src/app/model/patient';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  patientHistory: Patient[] = [] as Patient[];

  constructor(private route: ActivatedRoute, private commonService: CommonService) { }

  ngOnInit() {
    this.getPatientId();
  }

  getPatientId() {
    this.route.params.subscribe((params: Params) => {
      const patientId = params['id'];
      if (!isNullOrUndefined(patientId)) {
        this.commonService.getPatientHistory(patientId).subscribe(
          (data) => {
            this.patientHistory = data;
          }
        );
      }
    });
  }

}
