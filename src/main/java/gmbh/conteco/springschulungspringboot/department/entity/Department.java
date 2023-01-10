package gmbh.conteco.springschulungspringboot.department;

import jakarta.persistence.*;

@Entity
@Table(name = "dep")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id", nullable = false)
    private Long department_id;

    @Column(name = "name", nullable = false)
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
