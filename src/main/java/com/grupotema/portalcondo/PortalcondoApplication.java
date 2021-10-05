package com.grupotema.portalcondo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortalcondoApplication implements CommandLineRunner {

	//@Autowired
	//private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(PortalcondoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	s3Service.uploadFile("D:\\Programacao\\Fontes\\SpringBoot\\ws\\Fotos\\ana.jpg");
	}
}
