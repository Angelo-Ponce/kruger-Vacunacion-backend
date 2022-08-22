package com.kruger.repo;

import java.util.List;

import com.kruger.model.Employee;
import com.kruger.model.VaccineEmployee;
import com.kruger.model.VaccineStatus;

public interface IEmployeeRepo extends IGenericRepo<Employee, Integer>{
	
	List<Employee> findByVaccineStatus(VaccineStatus vaccineStatus);
	
	//List<Employee> findByVaccineEmployee(List<VaccineEmployee> vaccineEmployee);
}
