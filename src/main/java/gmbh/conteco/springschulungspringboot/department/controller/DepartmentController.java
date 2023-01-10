package gmbh.conteco.springschulungspringboot.department.controller;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }


}
