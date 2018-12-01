import { PrescriptionMed} from './prescriptionMedModel';

export interface PatientModel {
    patientId: number;
    doctorId: number;
    symptoms: string;
    height: string;
    weight: string;
    findings: string;
    medicines: PrescriptionMed[];
    followupDate: Date;
    bloodPressure: string;
    temprature: string;
}

