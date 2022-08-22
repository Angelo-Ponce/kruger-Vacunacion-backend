package com.kruger.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kruger.dto.VaccineStatusDto;
import com.kruger.model.VaccineStatus;
import com.kruger.service.IVaccineStatusService;

@RestController
@RequestMapping("/vaccinestatus")
public class VaccineStatusController {
	
	@Autowired
	private IVaccineStatusService vaccineStatusService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('getAll')")
	@GetMapping
	public ResponseEntity<List<VaccineStatusDto>> getAll() throws Exception{
		List<VaccineStatusDto> lstVaccine =  vaccineStatusService.findAll().stream().map( vstatus -> mapper.map( vstatus, VaccineStatusDto.class)).collect(Collectors.toList());
		return new ResponseEntity<List<VaccineStatusDto>>(lstVaccine, HttpStatus.OK);
	}
	
	@PreAuthorize("@authServiceImpl.hasAccessSystem('create')")
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody VaccineStatusDto dtoRequest ) throws Exception {
		VaccineStatus vaccineStatus = mapper.map(dtoRequest, VaccineStatus.class);
		VaccineStatus obj = vaccineStatusService.save(vaccineStatus);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVaccineStatus()).toUri();
		return ResponseEntity.created(location).build();
	}
}
