package com.kruger.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.dto.EmployeeDto;
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
}
