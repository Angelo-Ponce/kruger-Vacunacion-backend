package com.kruger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.model.VaccineStatus;
import com.kruger.repo.IGenericRepo;
import com.kruger.repo.IVaccineStatusRepo;
import com.kruger.service.IVaccineStatusService;

@Service
public class VaccineStatusServiceImpl extends CRUDServiceImpl<VaccineStatus, Integer> implements IVaccineStatusService{

	@Autowired
	private IVaccineStatusRepo vaccineStatusRepo;
	
	@Override
	protected IGenericRepo<VaccineStatus, Integer> getRepo() {
		return vaccineStatusRepo;
	}

}
