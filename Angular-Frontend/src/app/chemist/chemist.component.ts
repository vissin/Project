import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/service/common.service';
import { Prescription } from 'src/app/model/prescription';
import { PrescriptionUpdateModel } from 'src/app/model/prescriptionUpdateModel';

@Component({
  selector: 'app-chemist',
  templateUrl: './chemist.component.html',
  styleUrls: ['./chemist.component.css']
})
export class ChemistComponent implements OnInit {
  searchId: number;
  prescriptions: Prescription[];
  prescriptionUpdates: PrescriptionUpdateModel[] = [] as PrescriptionUpdateModel[];

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
    this.commonService.getPatientVisitDetails(this.searchId).subscribe(
      (data) => {
        debugger;
        this.prescriptions = data.prescriptionDTO;
        this.prescriptions.forEach(val => {
          const pres = {} as PrescriptionUpdateModel;
          pres.id = val.id;
          pres.provided = false;
          pres.medicine = val.medicine;
          this.prescriptionUpdates.push(pres);
        });
      }
    );
  }

  updatePrescriptionDetails(){
    this.commonService.updatePrescriptionDetails(this.prescriptionUpdates).subscribe(
      (data) => {
        debugger;
      }
    );
  }

}
