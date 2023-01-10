package gmbh.conteco.springschulungspringboot;

import gmbh.conteco.springschulungspringboot.department.Department;
import gmbh.conteco.springschulungspringboot.department.DepartmentRepository;
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
	CommandLineRunner myApp(DepartmentRepository departmentRepository) {
		return args -> {
			Department department = new Department();
			department.setName("IT-Entwicklung");

			departmentRepository.save(department);

			departmentRepository.findAll()
					.forEach(department1 -> System.out.println(department1.getName()));

		};
	}

}
