package claudioteles.com.github;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import claudioteles.com.github.dao.FactoryDao;
import claudioteles.com.github.models.Factory;

@SpringBootApplication
public class ApiSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringSecurityApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner seed(FactoryDao fd) {
		return (args) -> {
			System.err.println(fd.save(new Factory(null, "FABRICA_UM", (short) 130)));
			System.err.println(fd.save(new Factory(null, "FABRICA_DOIS", (short) 140)));
			System.err.println(fd.save(new Factory(null, "FABRICA_TRES", (short) 150)));
		};
	}

}
