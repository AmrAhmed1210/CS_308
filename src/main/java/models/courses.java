package models;

import java.util.Date;
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
@Table(name = "courses", schema = "system")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class courses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "system.STUDENT_SEQ", allocationSize = 1)
    @Column(name = "c_id")
    private Integer cid;
    @Column(name = "c_name")
    private String c_name;
}
