import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../../model/Employee';
import { EmployeeServiceService } from '../../service/employee-service.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent {
 http:any;
 constructor(private service: EmployeeServiceService,
  private router: Router) { }

  submitted=false;
  employee=new Employee();

  onSubmit(){
    this.submitted=true;
    this.save();
  }

  save(){
    this.service.createEmployee(this.employee).subscribe();
  }
}
