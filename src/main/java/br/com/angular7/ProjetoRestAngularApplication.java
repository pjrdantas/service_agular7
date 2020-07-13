package br.com.angular7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoRestAngularApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjetoRestAngularApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(ProjetoRestAngularApplication.class, args);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SERVIÇO PRONTO PARA SER CONSUMIDO!");
	}

}
