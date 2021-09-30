package com.grupotema.portalcondo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupotema.portalcondo.domain.Acesso;
import com.grupotema.portalcondo.domain.Condominio;
import com.grupotema.portalcondo.domain.Propriedade;
import com.grupotema.portalcondo.domain.Proprietario;
import com.grupotema.portalcondo.domain.Unidade;
import com.grupotema.portalcondo.domain.Usuario;
import com.grupotema.portalcondo.domain.enums.Perfil;
import com.grupotema.portalcondo.repositories.AcessoRepository;
import com.grupotema.portalcondo.repositories.CondominioRepository;
import com.grupotema.portalcondo.repositories.PropriedadeRepository;
import com.grupotema.portalcondo.repositories.ProprietarioRepository;
import com.grupotema.portalcondo.repositories.UnidadeRepository;
import com.grupotema.portalcondo.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private PropriedadeRepository propriedadeRepository;

	@Autowired
	private AcessoRepository acessoRepository;

	@Autowired
	private CondominioRepository condominioRepository;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public void instatiateTestDatabase() {
		
		Usuario usr1 = new Usuario(null, "Marlon Prado","marlonprado.cn@gmail.com","marlonprado", pe.encode("marlonprado"));
		Usuario usr2 = new Usuario(null, "Jose Pedro","josepedro@hotmail.com","josepedro", pe.encode("senhaJose"));
		Usuario usr3 = new Usuario(null, "Antonio Sa","antoniosa@uol.com.br","antoniosa", pe.encode("senhaAntonio"));
		Usuario usr4 = new Usuario(null, "Amelia Dias", "ameliadias@uol.com", "amelia", pe.encode("7723"));
		Usuario usr5 = new Usuario(null, "Carolina Medeiros", "medeiros@outlook.com", "carolmedeiros", pe.encode("came2000"));
		
		usr1.addPerfil(Perfil.ADMIN);
		usr2.addPerfil(Perfil.PROPRIETARIO);
		usr3.addPerfil(Perfil.PROPRIETARIO);
		usr4.addPerfil(Perfil.PROPRIETARIO);
		usr5.addPerfil(Perfil.PROPRIETARIO);
		
		Proprietario pro1 = new Proprietario(null, "Carlos Divinio","123.456.789-00", "carlos@grupotema.com.br");
		Proprietario pro2 = new Proprietario(null, "Marcelo Braz",  "951.357.852-97", "marcelo@gmail.com");
		Proprietario pro3 = new Proprietario(null, "Rodrigo rtres", "456.321.987-99", "rodrigo@uol.com");
		
		Propriedade pr1 = new Propriedade(null, pro1);
		Propriedade pr2 = new Propriedade(null, pro2);
		Propriedade pr3 = new Propriedade(null, pro3);
		Propriedade pr4 = new Propriedade(null, pro1);
		
		Acesso ac1 = new Acesso(null, 1, usr1, pr1);
		ac1.addPerfil(Perfil.ADMIN);
		
		Acesso ac2 = new Acesso(null, 1, usr2, pr2);
		ac2.addPerfil(Perfil.PROPRIETARIO);

		Acesso ac3 = new Acesso(null, 1, usr3, pr3);
		Acesso ac4 = new Acesso(null, 1, usr4, pr1);
		Acesso ac5 = new Acesso(null, 1, usr5, pr2);
		Acesso ac6 = new Acesso(null, 1, usr1, pr3);
		Acesso ac7 = new Acesso(null, 1, usr1, pr1);
		Acesso ac8 = new Acesso(null, 1, usr2, pr1);
		Acesso ac9 = new Acesso(null, 1, usr3, pr2);
		
		usr1.getAcessos().addAll(Arrays.asList(ac1,ac6,ac7));
		usr2.getAcessos().addAll(Arrays.asList(ac2,ac8));
		usr3.getAcessos().addAll(Arrays.asList(ac3,ac9));
		usr4.getAcessos().addAll(Arrays.asList(ac4));
		usr5.getAcessos().addAll(Arrays.asList(ac5));
		
		Condominio cond1 = new Condominio(null, "Chales Quadra 2A");
		Condominio cond2 = new Condominio(null, "Bento de Godoy");
		Condominio cond3 = new Condominio(null, "Cristais Rio Quente");
		Condominio cond4 = new Condominio(null, "Residencial Tamboril II");
		Condominio cond5 = new Condominio(null, "Chales Quadra 1A");
		Condominio cond6 = new Condominio(null, "Recando do Lago");
		Condominio cond7 = new Condominio(null, "Privê das Termas");
		Condominio cond8 = new Condominio(null, "Promenade Residence");
		Condominio cond9 = new Condominio(null, "Aguas da Serra");
		Condominio cond10= new Condominio(null, "Eldorado Flat");
		
		
		Unidade und11 = new Unidade(null, "1101", cond1, pr1);
		Unidade und12 = new Unidade(null, "1102", cond1, pr2);
		Unidade und13 = new Unidade(null, "1103", cond1, pr3);
		Unidade und21 = new Unidade(null, "2101", cond2, pr1);
		Unidade und22 = new Unidade(null, "2102", cond2, pr2);
		Unidade und23 = new Unidade(null, "2103", cond2, pr3);
		Unidade und31 = new Unidade(null, "3101", cond3, pr1);
		Unidade und32 = new Unidade(null, "3102", cond3, pr1);
		Unidade und33 = new Unidade(null, "3103", cond3, pr2);

		
		
		cond1.getUnidades().addAll(Arrays.asList(und11,und12,und13));
		cond2.getUnidades().addAll(Arrays.asList(und21,und22,und23));
		cond3.getUnidades().addAll(Arrays.asList(und31,und32,und33));
		
		usuarioRepository.saveAll(Arrays.asList(usr1,usr2,usr3,usr4,usr5));
		proprietarioRepository.saveAll(Arrays.asList(pro1,pro2,pro3));
		propriedadeRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4));
		acessoRepository.saveAll(Arrays.asList(ac1,ac2,ac3,ac4,ac5,ac6,ac7,ac8,ac9));
		
		condominioRepository.saveAll(Arrays.asList(cond1,cond2,cond3,cond4,cond5,cond6,cond7,cond8,cond9,cond10));
		unidadeRepository.saveAll(Arrays.asList(und11,und12,und13,und21,und22,und23,und31,und32,und33));
		
		
	}

}
