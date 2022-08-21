package com.kruger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.model.Employee;
import com.kruger.repo.IEmployeeRepo;
import com.kruger.repo.IGenericRepo;
import com.kruger.service.IEmployeeService;

@Service
public class EmployeeServiceImpl extends CRUDServiceImpl<Employee, Integer> implements IEmployeeService{

	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Override
	protected IGenericRepo<Employee, Integer> getRepo() {
		return employeeRepo;
	}

}
