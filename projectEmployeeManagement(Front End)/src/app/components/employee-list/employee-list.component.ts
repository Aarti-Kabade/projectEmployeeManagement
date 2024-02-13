import { Component } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Employee } from '../../model/Employee';
import { of } from 'rxjs/internal/observable/of';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent {
  public employees: Observable<Employee[]> =of([]);
  
  constructor(private service: EmployeeServiceService,
    private router: Router) {
      
    }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.employees= this.service.getAllEmployee();
  }

  deleteEmployee(id:number)
    {
      return this.service.deleteEmployee(id).subscribe((data)=>{
        console.log(data);
        this.getAll();
      })

    }

   employeeDetails(id:number){
    this.router.navigate(['details',id])
   }

   updateDetails(id:number){
    this.router.navigate(['update',id])
   }

}
