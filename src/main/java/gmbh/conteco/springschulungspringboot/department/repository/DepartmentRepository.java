package gmbh.conteco.springschulungspringboot.department.repository;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}