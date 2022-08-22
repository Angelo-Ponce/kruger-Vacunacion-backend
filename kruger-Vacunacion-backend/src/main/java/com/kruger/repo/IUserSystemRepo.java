package com.kruger.repo;

import com.kruger.model.UserSystem;

public interface IUserSystemRepo extends IGenericRepo<UserSystem, Integer>{
	
	UserSystem findOneByUsername(String username);
}
