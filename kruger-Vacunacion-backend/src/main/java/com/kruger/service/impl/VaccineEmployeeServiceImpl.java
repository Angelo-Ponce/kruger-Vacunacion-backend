package com.kruger.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.model.VaccineEmployee;
import com.kruger.model.VaccineType;
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

	@Override
	public List<VaccineEmployee> findByVaccineType(VaccineType vaccineType) {
		return vaccineEmployeeRepo.findByVaccineType(vaccineType);
	}

	@Override
	public List<VaccineEmployee> findByVaccineDate(LocalDateTime initialDate, LocalDateTime finalDate)
			throws Exception {
		return vaccineEmployeeRepo.findByVaccineDate(initialDate, finalDate.plusDays(1));
	}

}
