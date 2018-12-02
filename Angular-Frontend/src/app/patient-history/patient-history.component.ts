import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { CommonService } from 'src/app/service/common.service';
import { PatientHistoryDetails } from 'src/app/model/patientHistoryDetails';
import { Visit } from 'src/app/model/visit';
import { isNullOrUndefined } from 'util';
import { Params, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-patient-history',
  templateUrl: './patient-history.component.html',
  styleUrls: ['./patient-history.component.css']
})
export class PatientHistoryComponent implements OnInit {
  patient: Patient = {} as Patient;
  patientHistory: Visit[] = [] as Visit[];
  patientHistoryDetails: PatientHistoryDetails[] = [] as PatientHistoryDetails[];
  constructor(private commonService: CommonService, private route: ActivatedRoute) {
   }

  ngOnInit() {
      this.route.params.subscribe((params: Params) => {
        const patientId = params['id'];
        if (!isNullOrUndefined(patientId)) {
          this.commonService.getPatientHistory(patientId).subscribe(
            (data) => {
              debugger;
              this.patientHistory = data;
              this.patientHistory.forEach(val => {
                debugger;
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
