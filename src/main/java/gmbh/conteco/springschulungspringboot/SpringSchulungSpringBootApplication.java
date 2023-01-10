package gmbh.conteco.springschulungspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSchulungSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchulungSpringBootApplication.class, args);
		System.out.println("Hallo DB!");
	}

	@Bean
	CommandLineRunner myApp() {
		return args -> {
			System.out.println("Hallo Welt!");
		};
	}

}
