package com.kruger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.model.VaccineEmployee;
import com.kruger.repo.IGenericRepo;
import com.kruger.repo.IVaccineEmployeeRepo;
import com.kruger.service.IVaccineEmployeeService;

@Service
public class VaccineEmployeeServiceImpl extends CRUDServiceImpl<VaccineEmployee, Integer> implements IVaccineEmployeeService{

	@Autowired
	private IVaccineEmployeeRepo vaccineEmployeeRepo;
	
	@Override
	protected IGenericRepo<VaccineEmployee, Integer> getRepo() {
		return vaccineEmployeeRepo;
	}

}
