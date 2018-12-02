import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/service/common.service';
import { Prescription } from 'src/app/model/prescription';
import { PrescriptionUpdateModel } from 'src/app/model/prescriptionUpdateModel';
import { PatientHistoryDetails } from 'src/app/model/patientHistoryDetails';
import { Patient } from 'src/app/model/patient';

@Component({
  selector: 'app-chemist',
  templateUrl: './chemist.component.html',
  styleUrls: ['./chemist.component.css']
})
export class ChemistComponent implements OnInit {
  searchId: number;
  prescriptions: Prescription[];
  patient: Patient = {} as Patient  ;
  prescriptionUpdates: PrescriptionUpdateModel[] = [] as PrescriptionUpdateModel[];
  isPatient = false;

  constructor(private commonService: CommonService) { }

  ngOnInit() {

  }

  onChange(pres: PrescriptionUpdateModel, isChecked: boolean) {
    if (isChecked) {
      debugger;
      const index = this.prescriptionUpdates.indexOf(pres);
      this.prescriptionUpdates[index].provided = true;
    } else {
      const index = this.prescriptionUpdates.indexOf(pres);
      this.prescriptionUpdates[index].provided = false;
    }
  }

  onSearchSubmit() {
    this.prescriptions = [] as Prescription[];
    this.commonService.getPatientVisitDetails(this.searchId).subscribe(
      (data) => {
        debugger;
        this.isPatient = true;
        this.patient = data.patientDTO;
        this.prescriptions = data.prescriptionDTO;
        this.prescriptions.forEach(val => {
          const pres = {} as PrescriptionUpdateModel;
          pres.id = val.id;
          pres.provided = val.provided;
          pres.medicine = val.medicine;
          this.prescriptionUpdates.push(pres);
        });
      }
    );
  }

  updatePrescriptionDetails() {
    this.commonService.updatePrescriptionDetails(this.prescriptionUpdates).subscribe(
      (data) => {
        window.alert('Details has been added updated');
        this.isPatient = false;
      }
    );
  }

}
