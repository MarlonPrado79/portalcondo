package com.grupotema.portalcondo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.grupotema.portalcondo.domain.Usuario;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendUsuarioConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Inclusão de usuario realizada "+obj.getNome());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Usuário foi incluído. "+obj.getId()+"-"+obj.getNome());
		return sm;
	}
	
	@Override
	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = PrepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage PrepareNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: "+newPass);
		return sm;
	}
}
