package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeServiceInterface {

public Employee saveEmployee(Employee e) ;// for Multiple Employee new code here
	
	public List<Employee>saveAllEmployee(List<Employee>list);
	
	public Employee getOneEmployee(int id ) ;
	
	public List<Employee>getAllEmployee();
	
	public void deleteEmployee(int  id);

//	public Employee updateEmployee(int id, String firstName, String lastName);
	
	Employee updateEmployee(int id, Employee employee);
	
	public Employee getByEmail(String email);
		
	
//	public List<String> getEmployeeNames();

	
}
