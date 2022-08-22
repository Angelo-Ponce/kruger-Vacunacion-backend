package com.kruger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.model.VaccineType;
import com.kruger.repo.IGenericRepo;
import com.kruger.repo.IVaccineTypeRepo;
import com.kruger.service.IVaccineTypeService;

@Service
public class VaccineTypeServiceImpl extends CRUDServiceImpl<VaccineType, Integer> implements IVaccineTypeService{

	@Autowired
	private IVaccineTypeRepo iVaccineTypeRepo;
	
	@Override
	protected IGenericRepo<VaccineType, Integer> getRepo() {
		return iVaccineTypeRepo;
	}

}
