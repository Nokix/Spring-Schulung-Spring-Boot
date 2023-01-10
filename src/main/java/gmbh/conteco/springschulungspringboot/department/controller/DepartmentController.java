package gmbh.conteco.springschulungspringboot.department.controller;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        LOGGER.info("GET: getAllDepartments");
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/name/{name}")
    public Optional<Department> getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }

    @DeleteMapping("/name/{name}")
    public List<Department> deleteDepartmentsStartingWith(@PathVariable("name") String prefix) {
        return departmentService.deleteDepartemtsStartingWith(prefix);
    }

    @GetMapping("/name/presuf/{presuf}")
    public Optional<Department> getDepartmentByPrefixOrSuffix(@PathVariable("presuf") String presuf) {
        return departmentService.getDepartmentByPrefixOrSuffix(presuf);
    }
}
