package com.kruger.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kruger.dto.EmployeeDto;
import com.kruger.dto.EmployeeOnlyDto;
import com.kruger.dto.FilterIdDto;
import com.kruger.exception.ModelNotFoundException;
import com.kruger.model.Employee;
import com.kruger.model.VaccineStatus;
import com.kruger.model.VaccineType;
import com.kruger.service.IEmployeeService;
import com.kruger.service.IVaccineStatusService;
import com.kruger.service.IVaccineTypeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IVaccineStatusService vaccineStatusService;
	
	@Autowired
	private IVaccineTypeService vaccineTypeService;
	
	@Autowired
	private ModelMapper mapper;
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@PreAuthorize("@authServiceImpl.hasAccessSystem('getAll')")
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAll() throws Exception{
		List<EmployeeDto> lstEmployee =  employeeService.findAll().stream().map( emp -> mapper.map( emp, EmployeeDto.class)).collect(Collectors.toList());
		return new ResponseEntity<List<EmployeeDto>>(lstEmployee, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('getAll')")
	@GetMapping("/betweendatevaccine")
	public ResponseEntity<List<EmployeeOnlyDto>> getBetweenDateVaccine( @RequestParam(value = "initialDate") String initialDate, @RequestParam(value = "finalDate") String finalDate ) throws Exception{
		
		List<EmployeeOnlyDto> lstEmployee =  employeeService.betweenDateVaccineType(LocalDateTime.parse(initialDate), LocalDateTime.parse(finalDate));
		return new ResponseEntity<List<EmployeeOnlyDto>>(lstEmployee, HttpStatus.OK);

	}
	
	
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('create')")
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody EmployeeDto dtoRequest ) throws Exception {
		
		Employee employee = mapper.map(dtoRequest, Employee.class);
		
		Employee obj = employeeService.saveOrUpdateEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEmployee()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('getAll')")
	@PostMapping("/employeevaccinestatus")
	public ResponseEntity<List<EmployeeOnlyDto>> getEmployeeVaccineStatus(@RequestBody FilterIdDto dtoRequest) throws Exception{
		
		VaccineStatus vaccineStatus = vaccineStatusService.findById(dtoRequest.getId());
		if(vaccineStatus == null )
			throw new ModelNotFoundException("ID Vacuna no encontrado " + dtoRequest.getId());
		
		List<EmployeeOnlyDto> lstEmployee =  employeeService.findByVaccineStatus(vaccineStatus);
		return new ResponseEntity<List<EmployeeOnlyDto>>(lstEmployee, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('getAll')")
	@PostMapping("/employeevaccinetype")
	public ResponseEntity<List<EmployeeOnlyDto>> getEmployeeVaccineType(@RequestBody FilterIdDto dtoRequest) throws Exception{
		
		VaccineType vaccineType = vaccineTypeService.findById(dtoRequest.getId());
		if(vaccineType == null )
			throw new ModelNotFoundException("ID Tipo Vacuna no encontrado " + dtoRequest.getId());
		
		List<EmployeeOnlyDto> lstEmployee =  employeeService.findByVaccineType(vaccineType);
		return new ResponseEntity<List<EmployeeOnlyDto>>(lstEmployee, HttpStatus.OK);
	}
	
	
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('updateEmployee')")
	@PutMapping
	public ResponseEntity<Employee> update(@Valid @RequestBody EmployeeDto dtoRequest ) throws Exception {
		
		Employee employee = employeeService.findById(dtoRequest.getIdEmployee());
		if(employee == null)
			throw new ModelNotFoundException("Empleado no encontrado: " + dtoRequest.getIdEmployee());
		
		employee = null;
		employee = mapper.map(dtoRequest, Employee.class);
		
		Employee obj = employeeService.saveOrUpdateEmployee(employee);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
}
