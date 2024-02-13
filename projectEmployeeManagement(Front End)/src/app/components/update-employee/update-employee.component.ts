import { Component } from '@angular/core';
import { Employee } from '../../model/Employee';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent {

  id: number=0;
  employee: Employee=new Employee();

  constructor(private route: ActivatedRoute,private router: Router,
    private service: EmployeeServiceService) { }


    ngOnInit() {
      this.employee = new Employee();
  
      this.id = this.route.snapshot.params['id'];
      
      
      this.service.getOneEmployee(this.id).subscribe((data: Employee)=>{
        console.log(data);
        this.employee=data;
      })
            
    }

    onSubmit(){
      this. updateEmployee();
    }

    updateEmployee()
    {
      this.service.updateEmployee(this.employee).subscribe((data)=>{
        console.log(data);
        this.employee= new Employee();
        this.gotoList();
      })
    }

    gotoList(){
      this.router.navigate(['list']);
    }


  
}