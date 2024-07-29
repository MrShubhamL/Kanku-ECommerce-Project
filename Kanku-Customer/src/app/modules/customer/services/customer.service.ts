import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import BASE_URL from '../../../auth/services/helper';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  public getCustomerInfo(username: any):Observable<any>{
    return this.http.post(BASE_URL + "/customer/customerProfile", username);
  }

  public updateProfile(profile:any):Observable<any>{
    return this.http.put(BASE_URL + "/customer/updateProfile", profile);
  }

}
