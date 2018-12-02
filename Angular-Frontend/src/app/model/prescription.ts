export interface Prescription {
    id: number;
    medicine: string;
    dosage: string;
    days: number;
    times: number;
    visitId: string;
    provided: boolean;
}
