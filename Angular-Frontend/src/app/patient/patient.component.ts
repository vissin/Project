import { Component, OnInit } from '@angular/core';
import { isNullOrUndefined } from 'util';
import { ActivatedRoute, Params } from '@angular/router';
import { CommonService } from 'src/app/service/common.service';
import { Patient } from 'src/app/model/patient';
import { PatientHistoryDetails } from 'src/app/model/patientHistoryDetails';
import { Visit } from 'src/app/model/visit';
import { VisitDetails } from 'src/app/model/visitDetails';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  patientHistory: Visit[] = [] as Visit[];
  patientHistoryDetails: PatientHistoryDetails[] = [] as PatientHistoryDetails[];

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
            this.patientHistory.forEach(val => {
                const patientDet = {} as PatientHistoryDetails;
                patientDet.doctor = val.doctorDTO.name;
                patientDet.date = val.visitDTO.visitDate;
                const medicines = [];
                val.prescriptionDTO.forEach(x => {
                  medicines.push(x.medicine);
                });
                patientDet.medicines = medicines.join(',');
                this.patientHistoryDetails.push(patientDet);
            });
          }
        );
      }
    });
  }

}
