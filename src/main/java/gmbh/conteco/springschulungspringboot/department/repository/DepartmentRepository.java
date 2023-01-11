package gmbh.conteco.springschulungspringboot.department.repository;

import gmbh.conteco.springschulungspringboot.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> deleteByNameStartsWithIgnoreCase(String name);

    Optional<Department> findByName(String name);

    @Query("select d from Department d where d.name like concat(:preOrSuffix, '%') or d.name like concat('%', :preOrSuffix)")
    Optional<Department> findByPreOrSuffix(String preOrSuffix);
}