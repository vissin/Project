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
        debugger;
        return this.http.post(this.baseUrl + 'user/login', loginModel).map(res => res);
    }

    getPatientHistory(id): Observable<any> {
        return this.http.get(this.baseUrl + 'patienthistory/' + id).map(res => res);
    }
    getPatientbyIdOnSearch(searchId) {
        debugger;
        return this.http.get(this.baseUrl + 'patient/' + searchId).map(res => res);
    }
    addPatientDetails(patientModel) {
        return this.http.put(this.baseUrl + 'visit/update', patientModel).map(res => res);
    }
}
