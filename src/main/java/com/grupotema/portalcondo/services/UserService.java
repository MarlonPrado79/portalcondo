package com.grupotema.portalcondo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.grupotema.portalcondo.security.UserSS;

public class UserService {
	
	//Retornar usuario logado//
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e){
			return null;
		}
		
	}

}
