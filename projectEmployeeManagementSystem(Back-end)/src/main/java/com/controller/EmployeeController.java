package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/e")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface empService;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee e)// we can give any name in the place of addemployee
	{
		 empService.saveEmployee(e);
		 return e;
		 
	}
	
	
	
//	@PostMapping("/add")
//	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
//		Employee emp=empService.saveEmployee(e);
//		return ResponseEntity.status(HttpStatus.CREATED).header("add", "save Employee").body(emp);
//	}
	@PostMapping("addAll") // / is or concept
	public List<Employee> addAllEmployee(@RequestBody List<Employee> list) {
		return empService.saveAllEmployee(list);
		
	}
	
	@GetMapping("/getOne/{id}")
   public Employee findOneEmployee(@PathVariable int id) {
		Employee e= new Employee();          // to handle exception in proper way we use try catch method
		try {
			e=empService.getOneEmployee(id);
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return e;
		
	}
	
	@GetMapping("/getAll")
    public List<Employee> findgetAllEmployee() {
		
		return empService.getAllEmployee();
	}
	@DeleteMapping("/deletebyid/{id}")
	public void deleteEmployee(@PathVariable int id) 
	{
		empService.deleteEmployee(id);
	}

//	@PutMapping("update")
//	public Employee updateEmployee( @RequestBody Employee e) {
//		
//		return empService.updateEmployee(e);
//			
//	}
	
	 @PutMapping("update")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
	        Employee updatedEmployee = empService.updateEmployee(id, employee);
	        if (updatedEmployee != null) {
	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	@GetMapping("getemail/{email}")
    public Employee searchByEmail(@PathVariable String email) {
		
		return empService.getByEmail(email);
	}
	
//	@GetMapping("getNames")
//    public List<String> searchEmployeeNames() {
//		
//		return empService.getEmployeeNames();
//	}
}
