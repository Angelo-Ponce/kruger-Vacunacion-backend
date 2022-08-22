package com.kruger.service;

import java.time.LocalDateTime;
import java.util.List;

import com.kruger.dto.EmployeeOnlyDto;
import com.kruger.model.Employee;
import com.kruger.model.VaccineStatus;
import com.kruger.model.VaccineType;

public interface IEmployeeService extends ICRUDService<Employee, Integer>{
	
	Employee saveOrUpdateEmployee( Employee employee ) throws Exception;
	
	List<EmployeeOnlyDto> findByVaccineStatus(VaccineStatus vaccineStatus) throws Exception;
	
	List<EmployeeOnlyDto> findByVaccineType(VaccineType vaccineType) throws Exception;
	
	List<EmployeeOnlyDto> betweenDateVaccineType(LocalDateTime initialDate, LocalDateTime finalDate) throws Exception;
	
}
