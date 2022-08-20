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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kruger.dto.VaccineTypeDto;
import com.kruger.model.VaccineType;
import com.kruger.service.IVaccineTypeService;

@RestController
@RequestMapping("/vaccinetype")
public class VaccineTypeController {

	@Autowired
	private IVaccineTypeService vTypeService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<VaccineTypeDto>> getAll() throws Exception{
		List<VaccineTypeDto> lstVaccine =  vTypeService.findAll().stream().map( vtype -> mapper.map( vtype, VaccineTypeDto.class)).collect(Collectors.toList());
		return new ResponseEntity<List<VaccineTypeDto>>(lstVaccine, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody VaccineTypeDto dtoRequest ) throws Exception {
		VaccineType vaccineType = mapper.map(dtoRequest, VaccineType.class);
		//VaccineType obj = vTypeService.save(vaccineType);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
