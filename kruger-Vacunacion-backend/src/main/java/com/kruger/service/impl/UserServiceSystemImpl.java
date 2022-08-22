package com.kruger.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kruger.model.UserSystem;
import com.kruger.repo.IUserSystemRepo;

@Service
public class UserServiceSystemImpl implements UserDetailsService{

	@Autowired
	private IUserSystemRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSystem usuario = userRepo.findOneByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> rols = new ArrayList<>();
		
		usuario.getRols().forEach(rol -> {
			rols.add(new SimpleGrantedAuthority(rol.getName()));
		});
				
		UserDetails userD = new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, rols);
		
		return userD;
	}

}
