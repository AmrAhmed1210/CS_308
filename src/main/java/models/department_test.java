package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department_test", schema = "system")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class department_test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", sequenceName = "system.DEPARTMENT_SEQ", allocationSize = 1)
    @Column(name = "d_id")
    private Integer dId;

    @Column(name = "d_name")
    private String dName;
}
