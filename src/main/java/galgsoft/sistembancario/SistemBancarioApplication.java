package galgsoft.sistembancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SistemBancarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemBancarioApplication.class, args);
	}

}
