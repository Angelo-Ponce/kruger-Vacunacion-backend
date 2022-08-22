package com.kruger.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kruger.constants.Constants;
import com.kruger.dto.EmployeeDto;
import com.kruger.dto.EmployeeOnlyDto;
import com.kruger.dto.VaccineEmployeeDto;
import com.kruger.model.Employee;
import com.kruger.model.VaccineEmployee;
import com.kruger.model.VaccineStatus;
import com.kruger.model.VaccineType;
import com.kruger.repo.IEmployeeRepo;
import com.kruger.repo.IGenericRepo;
import com.kruger.repo.IVaccineEmployeeRepo;
import com.kruger.service.IEmployeeService;

@Service
public class EmployeeServiceImpl extends CRUDServiceImpl<Employee, Integer> implements IEmployeeService{

	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Autowired
	private IVaccineEmployeeRepo vaccineEmployeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
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
		
		employeeRepo.save(employee);		
		return employee;
	}

	@Override
	public List<EmployeeOnlyDto> findByVaccineStatus(VaccineStatus vaccineStatus) throws Exception {
		
		List<EmployeeOnlyDto> lstEmployee = employeeRepo.findByVaccineStatus(vaccineStatus).stream().map(lst -> mapper.map(lst , EmployeeOnlyDto.class)).collect(Collectors.toList());;
		
		return lstEmployee;
	}

	@Override
	public List<EmployeeOnlyDto> findByVaccineType(VaccineType vaccineType) {
		
		List<VaccineEmployee> lstVaccine = vaccineEmployeeRepo.findByVaccineType(vaccineType);
		
		List<EmployeeOnlyDto> lstEmployee = lstVaccine.stream().map(lst -> mapper.map(lst.getEmployee(), EmployeeOnlyDto.class)).collect(Collectors.toList());;
		
		
		return lstEmployee;
	}

	@Override
	public List<EmployeeOnlyDto> betweenDateVaccineType(LocalDateTime initialDate, LocalDateTime finalDate)
			throws Exception {
		
		List<VaccineEmployee> lstVaccine = vaccineEmployeeRepo.findByVaccineDate(initialDate, finalDate);
		
		List<EmployeeOnlyDto> lstEmployee = lstVaccine.stream().map(lst -> mapper.map(lst.getEmployee(), EmployeeOnlyDto.class)).collect(Collectors.toList());;
		
		return lstEmployee;
	}

}
