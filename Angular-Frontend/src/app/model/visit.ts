import { Patient } from 'src/app/model/patient';
import { Doctor } from 'src/app/model/doctor';
import { Prescription } from 'src/app/model/prescription';

export interface Visit {
    visitId: number;
    patientDTO: Patient;
    doctorDTO: Doctor;
    prescriptionDTO: Prescription[];
}
