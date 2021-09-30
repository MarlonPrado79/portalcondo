package com.grupotema.portalcondo.services;

import org.springframework.mail.SimpleMailMessage;

import com.grupotema.portalcondo.domain.Usuario;

public interface EmailService {

	void sendUsuarioConfirmationEmail(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	
	
}
