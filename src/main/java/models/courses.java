package models;

import java.util.List;
import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "system.COURSE_SEQ", allocationSize = 1)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_name")
    private String name;

//    @ManyToMany(mappedBy = "courses")
//    private List<Student> students;
}