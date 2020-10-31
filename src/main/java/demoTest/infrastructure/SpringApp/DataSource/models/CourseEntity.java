package demoTest.infrastructure.SpringApp.DataSource.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CourseEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;
}
