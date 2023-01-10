package gmbh.conteco.springschulungspringboot.department.service;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.exception.DepartmentNotFoundExeption;
import gmbh.conteco.springschulungspringboot.department.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().department_id(1L).name("IT").build();

        Mockito.when(departmentRepository.findByName("IT")).thenReturn(Optional.of(department));
        Mockito.when(departmentRepository.findByName("Hamburger")).thenReturn(Optional.empty());
    }

    @Test
    @DisplayName("Finde valides Department per Name")
    void getDepartmentByName() throws DepartmentNotFoundExeption {
        String departmentName = "IT";
        Department department = departmentService.getDepartmentByName(departmentName).get();
        assertEquals(departmentName, department.getName());
    }

    @Test
    void getDepartmentByName_invalidName() {
        assertThrows(DepartmentNotFoundExeption.class, () -> departmentService.getDepartmentByName("Hamburger"));
    }
}