package com.kruger.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kruger.dto.EmployeeDto;
import com.kruger.exception.ModelNotFoundException;
import com.kruger.model.Employee;
import com.kruger.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAll() throws Exception{
		List<EmployeeDto> lstEmployee =  employeeService.findAll().stream().map( emp -> mapper.map( emp, EmployeeDto.class)).collect(Collectors.toList());
		return new ResponseEntity<List<EmployeeDto>>(lstEmployee, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody EmployeeDto dtoRequest ) throws Exception {
		
		Employee employee = mapper.map(dtoRequest, Employee.class);
		
		Employee obj = employeeService.saveOrUpdateEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Employee> update(@Valid @RequestBody EmployeeDto dtoRequest ) throws Exception {
		
		Employee employee = employeeService.findById(dtoRequest.getIdEmployee());
		if(employee == null)
			throw new ModelNotFoundException("Empleado no encontrado: " + dtoRequest.getIdEmployee());
		
		employee = mapper.map(dtoRequest, Employee.class);
		
		Employee obj = employeeService.saveOrUpdateEmployee(employee);
		
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
}
