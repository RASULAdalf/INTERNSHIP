package lk.seekerscloud.InternshipTask.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column(length = 45)
    private String id;
    @Column(length = 45)
    private String name;
    @Column(length = 255)
    private String address;
    @Column(length = 45)
    private String contact;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Student_has_Program> studentHasPrograms = new ArrayList<>();

}
