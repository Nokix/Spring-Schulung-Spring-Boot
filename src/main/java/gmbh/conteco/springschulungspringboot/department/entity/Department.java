package gmbh.conteco.springschulungspringboot.department.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "dep")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id", nullable = false)
    private Long department_id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Department name must not be blank.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartment_id() {
        return department_id;
    }
}
