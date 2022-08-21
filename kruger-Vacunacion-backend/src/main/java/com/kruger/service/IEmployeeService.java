package com.kruger.service;

import com.kruger.model.Employee;

public interface IEmployeeService extends ICRUDService<Employee, Integer>{
	
	Employee saveOrUpdateEmployee( Employee employee ) throws Exception;
}
