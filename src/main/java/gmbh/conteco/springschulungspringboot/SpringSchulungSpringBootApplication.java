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

    @Bean
    CommandLineRunner myApp(DepartmentRepository departmentRepository) {
        return args -> {
            Department department0 = new Department();
            department0.setName("IT-Entwicklung");
            departmentRepository.save(department0);
            Department department1 = new Department();
            department1.setName("Vertrieb").setDepartment_id(4L);
            departmentRepository.save(department1);
            Department department2 = Department.builder().name("Personal").build();

            departmentRepository.save(department2);

            departmentRepository.findAll()
                    .forEach(d -> System.out.println(d.getName()));

        };
    }

}
