package com.kruger.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kruger.model.VaccineEmployee;
import com.kruger.model.VaccineType;

public interface IVaccineEmployeeRepo extends IGenericRepo<VaccineEmployee, Integer>{
	
	List<VaccineEmployee> findByVaccineType(VaccineType vaccineType);
	
	@Query("FROM VaccineEmployee e WHERE e.vaccineDate BETWEEN :initialDate AND :finalDate")
	List<VaccineEmployee> findByVaccineDate(@Param("initialDate") LocalDateTime initialDate, @Param("finalDate") LocalDateTime finalDate);
	
}
