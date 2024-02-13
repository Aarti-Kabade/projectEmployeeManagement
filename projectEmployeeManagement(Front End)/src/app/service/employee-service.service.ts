import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  baseUrl='http://localhost:9090';
  constructor(private http:HttpClient) { }

  createEmployee(employee: Object): Observable<Object> {
    console.log(employee);
    return this.http.post(`${this.baseUrl}/e/add`,employee);
  }

  getAllEmployee():any
  {
    return this.http.get(`${this.baseUrl}/e/getAll`);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/e/deletebyid/${id}`, { responseType: 'text' });
  }

  getOneEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/e/getOne/${id}`);
  }

  updateEmployee(employee:object){
    return this.http.put(`${this.baseUrl}/e/update`,employee);
  }
}
