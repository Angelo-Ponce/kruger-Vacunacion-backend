package com.kruger.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

	// Se puede validar con la conexion directa a la BD
	// con los permisos otorgados por rol
	// simulacion
	public boolean hasAccessSystem(String path) {
		
		String nameRol = "";
		boolean accessUser = false;
		
		switch (path) {
			case "create":
				nameRol = "ADMIN";
				break;
				
			case "updateAll":
				nameRol = "ADMIN";
				break;
				
			case "getAll":
				nameRol = "ADMIN";
				break;
	
			case "deleteAll":
				nameRol = "ADMIN";
				break;
				
			case "updateEmployee":
				nameRol = "ADMIN,USER";
				break;
				
			case "getId":
				nameRol = "ADMIN";
				break;
		}
		String nameRoles[] = nameRol.split(",");
		
		Authentication userLogin = SecurityContextHolder.getContext().getAuthentication();
		
		for (GrantedAuthority auth : userLogin.getAuthorities()) {
			String rolUser = auth.getAuthority();
			System.out.println(rolUser);

			for (String rolName : nameRoles) {
				if (rolUser.equalsIgnoreCase(rolName)) {
					accessUser = true;
				}
			}
		}
		
		return accessUser;
	}
}
