package com.grupotema.portalcondo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupotema.portalcondo.domain.AcessoProp;
import com.grupotema.portalcondo.domain.Cadastro;
import com.grupotema.portalcondo.domain.Condominio;
import com.grupotema.portalcondo.domain.Proprietario;
import com.grupotema.portalcondo.domain.Unidade;
import com.grupotema.portalcondo.domain.Usuario;
import com.grupotema.portalcondo.repositories.AcessoPropRepository;
import com.grupotema.portalcondo.repositories.CadastroRepository;
import com.grupotema.portalcondo.repositories.CondominioRepository;
import com.grupotema.portalcondo.repositories.ProprietarioRepository;
import com.grupotema.portalcondo.repositories.UnidadeRepository;
import com.grupotema.portalcondo.repositories.UsuarioRepository;

@SpringBootApplication
public class PortalcondoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AcessoPropRepository acessosPropRepository;
	
	@Autowired
	private CondominioRepository condominioRepository;
	@Autowired
	private UnidadeRepository unidadeRepository;
	@Autowired
	private CadastroRepository cadastroRepository;
	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PortalcondoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usr1 = new Usuario(null, "Maria Jose", "maria", "123", "G");
		Usuario usr2 = new Usuario(null, "Jose Pedro", "josepa", "321", "G");
		usuarioRepository.saveAll(Arrays.asList(usr1, usr2));
	
		Cadastro cad1 = new Cadastro(null, "Marlon Prado", "843.114.871-34", "marlonprado.cn@gmail.com");
		Cadastro cad2 = new Cadastro(null, "Carlos Divino", "548.987.254-81", "carlos@hotmail.com");
		Cadastro cad3 = new Cadastro(null, "Tema Hard Soft", "07.144.222/0001-27", "grupotema@grupotema.com.br");
	    cadastroRepository.saveAll(Arrays.asList(cad1,cad2,cad3));


	    AcessoProp ap1 = new AcessoProp(null, "Sindico");
		AcessoProp ap2 = new AcessoProp(null, "Proprietario");

		Proprietario pr1 = new Proprietario(null, "Carlos Divino");
	    Proprietario pr2 = new Proprietario(null, "Amarildo Jose");
	    Proprietario pr3 = new Proprietario(null, "Jose de Alencar");
	    
	    ap1.getProprietarios().addAll(Arrays.asList(pr1,pr2,pr3));
	    ap2.getProprietarios().addAll(Arrays.asList(pr2));
	    
	    pr1.getAcessosProp().addAll(Arrays.asList(ap1));
	    pr2.getAcessosProp().addAll(Arrays.asList(ap1,ap2));
	    pr3.getAcessosProp().addAll(Arrays.asList(ap1));

	    acessosPropRepository.saveAll(Arrays.asList(ap1,ap2));
	    proprietarioRepository.saveAll(Arrays.asList(pr1,pr2,pr3));
		
		
		Condominio cd1 = new Condominio(null, "TERMAS DAS CALDAS");
		Condominio cd2 = new Condominio(null, "PRIVE DAS TERMAS");
		condominioRepository.saveAll(Arrays.asList(cd1, cd2));
		
		Unidade un11 = new Unidade(null, "A0101", cd1);
		Unidade un12 = new Unidade(null, "A0102", cd1);
		Unidade un21 = new Unidade(null, "B0101", cd2);
		Unidade un22 = new Unidade(null, "B0102", cd2);
		Unidade un23 = new Unidade(null, "B0103", cd2);
	    unidadeRepository.saveAll(Arrays.asList(un11,un12,un21,un22,un23));
    
	}

}
