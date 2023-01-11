package gmbh.conteco.springschulungspringboot.department.controller;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        Department input = Department.builder().name("IT").build();
        Department output = Department.builder().name("IT").department_id(1L).build();

        Mockito.when(departmentService.saveDepartment(input)).thenReturn(output);
    }

    @Test
    void saveDepartment() throws Exception {
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/department/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"IT\"}");
        mockMvc.perform(post).andExpect(MockMvcResultMatchers.status().isOk());
    }
}