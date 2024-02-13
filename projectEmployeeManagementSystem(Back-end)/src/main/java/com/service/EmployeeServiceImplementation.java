package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Employee saveEmployee(Employee e) {
		empRepo.save(e);
		return e;
	}

	@Override
	public List<Employee> saveAllEmployee(List<Employee> list) {
		empRepo.saveAll(list);
		return list;
	}

	@Override
	public Employee getOneEmployee(int id) {
		
		return empRepo.findById(id).orElse(null);
	}

//    public Employee getOneEmployee(int id) {
//		
//		return empRepo.findById(id).orElseThrow(
//				()-> new NoSuchEmployeeException("Employee not found exception"+id)
//				);
//	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public void deleteEmployee(int id) 
	{
	
		empRepo.deleteById(id);
		
		// TODO Auto-generated method stub
		
	}
	
//	

//	 @Override
//	    public Employee updateEmployee(int id, String firstName, String lastName) {
//	        empRepo.updateEmployeeName(id, firstName, lastName);
//			return null;
//	    }
	
//	@Override
//    public Employee updateEmployee(int id, String firstName, String lastName) {
//        Employee existEmployee = empRepo.findById(id).orElse(null);
//        if (existEmployee != null) {
//            existEmployee.setFirstName(firstName);
//            existEmployee.setLastName(lastName);
//            return empRepo.save(existEmployee);
//        }
//        return null; // Or throw an exception if you prefer
//    }
	
	@Override
	public Employee getByEmail(String email) {
		
		return empRepo.findByEmail(email);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee existingEmployee = empRepo.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            return empRepo.save(existingEmployee);
        }
        return null;
		
	}

//	@Override
//	public List<String> getEmployeeNames() {
//		
//		return empRepo.findEmployeeNames();
//	}

	

	

	

}
