package gmbh.conteco.springschulungspringboot.department.repository;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("IT").build();
        testEntityManager.persist(department);
    }

    @Test
    void findByName() {
        Optional<Department> departmentOptional = departmentRepository.findByName("IT");
        assertEquals(departmentOptional.get().getName(), "IT");
    }
}