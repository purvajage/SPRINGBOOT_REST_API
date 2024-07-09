package com.Springboot_Crud_Rest_Api_Validation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot_Crud_Rest_Api_Validation.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	

	Optional<Employee> findById(Long employeeId);

	List<Employee> findAll();



	List<Employee> findByPosition(String position);


}
