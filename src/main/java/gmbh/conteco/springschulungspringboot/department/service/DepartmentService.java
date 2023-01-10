package gmbh.conteco.springschulungspringboot.department.service;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import gmbh.conteco.springschulungspringboot.department.exception.DepartmentNotFoundExeption;
import gmbh.conteco.springschulungspringboot.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) throws DepartmentNotFoundExeption {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new DepartmentNotFoundExeption("No department found with id: " + id);
        }
        return optionalDepartment;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentByName(String name) throws DepartmentNotFoundExeption {
        Optional<Department> departmentOptional = departmentRepository.findByName(name);
        if (departmentOptional.isEmpty()) throw new DepartmentNotFoundExeption("No department with name: " + name);
        return departmentOptional;
    }

    @Transactional
    public List<Department> deleteDepartemtsStartingWith(String prefix) {
        return departmentRepository.deleteByNameStartsWithIgnoreCase(prefix);
    }

    public Optional<Department> getDepartmentByPrefixOrSuffix(String presuf) {
        return departmentRepository.findByPreOrSuffix(presuf);
    }
}
