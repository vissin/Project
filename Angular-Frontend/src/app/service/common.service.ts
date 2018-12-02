import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root',
})
export class CommonService {

    baseUrl = 'http://SLW10350.spanservices.com:8080/SpringRestHibernate/';

    constructor(private http: HttpClient) { }

    userLogin(loginModel): Observable<any> {
        return this.http.post(this.baseUrl + 'user/login', loginModel).map(res => res);
    }

    getPatientHistory(id): Observable<any> {
        return this.http.get(this.baseUrl + 'patienthistory/' + id).map(res => res);
    }

    getPatientVisitDetails(id): Observable<any> {
        return this.http.get(this.baseUrl + 'prescription/' + id).map(res => res);
    }

    updatePrescriptionDetails(presUpdate): Observable<any> {
        return this.http.put(this.baseUrl + 'prescription/update', presUpdate).map(res => res);
    }

    getPatientbyIdOnSearch(searchId) {
        debugger;
        return this.http.get(this.baseUrl + 'patient/' + searchId).map(res => res);
    }
    addPatientDetails(patientModel) {
        return this.http.put(this.baseUrl + 'visit/update', patientModel).map(res => res);
    }
}
