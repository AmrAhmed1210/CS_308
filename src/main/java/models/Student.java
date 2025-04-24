package models;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "student", schema = "system")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "system.STUDENT_SEQ", allocationSize = 1)
    @Column(name = "s_id")
    private Integer id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private Integer age;
    @Column(name = "joined_date")
    private Date joinedDate;
    @Column(name = "d_id")
    private Integer dId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "d_id", insertable = false, updatable = false)
    private department_test departmenTtest;
}
