package com.Springboot_Crud_Rest_Api_Validation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Springboot_Crud_Rest_Api_Validation.exception.Resourcenotfoundexception;
import com.Springboot_Crud_Rest_Api_Validation.model.Employee;
import com.Springboot_Crud_Rest_Api_Validation.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws Resourcenotfoundexception {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new Resourcenotfoundexception("employee not found"));
		return ResponseEntity.ok().body(employee);
	}
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@DeleteMapping("/employee/{id}")
	public Map<String ,Boolean> deleteEmployee(@PathVariable(value="id")Long employeeId)
		throws Resourcenotfoundexception{
		   Employee employee=employeeRepository.findById(employeeId)
				   .orElseThrow(() -> new Resourcenotfoundexception("employee not found"));
		   employeeRepository.delete(employee);
		   Map<String,Boolean>response = new HashMap<>();
		   response.put("deleted",Boolean.TRUE);
		   return response;
	}
	  @DeleteMapping("/employees")
	    public Map<String, Boolean> deleteAllEmployees() {
	        employeeRepository.deleteAll();
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("allDeleted", Boolean.TRUE);
	        return response;
	    }

	    @GetMapping("/employees/position/{position}")
	    public List<Employee> getEmployeesByPosition(@PathVariable(value = "position") String position) {
	        return employeeRepository.findByPosition(position);
	    }
	}
	


