package gmbh.conteco.springschulungspringboot.department.repository;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> deleteByNameStartsWithIgnoreCase(String name);
    Optional<Department> findByName(String name);
}