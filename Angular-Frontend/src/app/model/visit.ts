import { Patient } from 'src/app/model/patient';
import { Doctor } from 'src/app/model/doctor';
import { Prescription } from 'src/app/model/prescription';
import { VisitDetails } from 'src/app/model/visitDetails';

export interface Visit {
    visitId: number;
    patientDTO: Patient;
    visitDTO: VisitDetails;
    doctorDTO: Doctor;
    prescriptionDTO: Prescription[];
}
