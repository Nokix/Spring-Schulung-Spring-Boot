package gmbh.conteco.springschulungspringboot.department.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "dep")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id", nullable = false)
    private Long department_id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Department name must not be blank.")
    @ToString.Exclude
    private String name;
}
