package gmbh.conteco.springschulungspringboot;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSchulungSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSchulungSpringBootApplication.class, args);
    }
}
