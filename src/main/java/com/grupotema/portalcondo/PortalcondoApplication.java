package com.grupotema.portalcondo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupotema.portalcondo.domain.Usuario;
import com.grupotema.portalcondo.repositories.UsuarioRepository;

@SpringBootApplication
public class PortalcondoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PortalcondoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usr1 = new Usuario(null, "Maria Jose", "maria", "123");
		Usuario usr2 = new Usuario(null, "Jose Pedro", "josepa", "321");
		
		usuarioRepository.saveAll(Arrays.asList(usr1, usr2));
		
	}

}
