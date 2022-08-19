package com.kruger.service.impl;

import java.util.List;

import com.kruger.repo.IGenericRepo;
import com.kruger.service.ICRUDService;

public abstract class CRUDServiceImpl<T, ID> implements ICRUDService<T, ID>{
	
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T save(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T update(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T findById(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void deleteById(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
