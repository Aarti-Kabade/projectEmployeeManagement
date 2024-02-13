import { Component } from '@angular/core';
import { Employee } from '../../model/Employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../../service/employee-service.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css'
})
export class EmployeeDetailsComponent {

  id: number=0;
  employee: Employee=new Employee();

  constructor(private route: ActivatedRoute,private router: Router,
    private service: EmployeeServiceService) { }

    ngOnInit() {
      this.employee = new Employee();
  
      this.id = this.route.snapshot.params['id'];
      
      
      this.service.getOneEmployee(this.id).subscribe((data)=>{
        console.log(data);
        this.employee=data;
      })


}

list(){
  this.router.navigate(['list']);
}
}
