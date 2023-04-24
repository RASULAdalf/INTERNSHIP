package lk.seekerscloud.InternshipTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    @Id
    @Column(length = 45)
    private String id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String duration;
    @Column(length = 45)
    private double cost;
    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student_has_Program> studentHasPrograms = new ArrayList<>();
}
