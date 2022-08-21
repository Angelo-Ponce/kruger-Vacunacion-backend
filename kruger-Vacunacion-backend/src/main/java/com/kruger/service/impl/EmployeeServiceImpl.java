package com.kruger.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.constants.Constants;
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

	@Transactional
	@Override
	public Employee saveOrUpdateEmployee(Employee employee) throws Exception {

		if( employee.getVaccineStatus() != null && employee.getVaccineStatus().getIdVaccineStatus() == Constants.VACUNADO) {
			if(employee.getVaccineEmployee() != null ) {
				
				employee.getVaccineEmployee().forEach(vem -> vem.setEmployee(employee));
				
			} else {
				throw new Exception("Empleado vacunado, por favor llenar datos de la vacuna");
			}
		}
		//employeeRepo.save(employee);		
		return employee;
	}

}
