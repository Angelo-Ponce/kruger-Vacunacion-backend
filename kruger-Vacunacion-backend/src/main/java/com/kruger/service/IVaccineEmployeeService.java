package com.kruger.service;

import java.time.LocalDateTime;
import java.util.List;

import com.kruger.model.VaccineEmployee;
import com.kruger.model.VaccineType;

public interface IVaccineEmployeeService extends ICRUDService<VaccineEmployee, Integer>{

	List<VaccineEmployee> findByVaccineType(VaccineType vaccineType) throws Exception;
	
	List<VaccineEmployee> findByVaccineDate(LocalDateTime initialDate, LocalDateTime finalDate) throws Exception;
	
}
