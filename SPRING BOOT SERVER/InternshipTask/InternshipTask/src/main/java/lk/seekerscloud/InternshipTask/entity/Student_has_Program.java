package lk.seekerscloud.InternshipTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student_has_Program {
    @EmbeddedId
    private Student_has_ProgramKey studentHasProgramKey = new Student_has_ProgramKey();
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "program_id")
    private Program program;


    @Column(length = 45)
    private String  registerDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student_has_Program)) return false;
        Student_has_Program that = (Student_has_Program) o;
        return getStudentHasProgramKey().equals(that.getStudentHasProgramKey()) && getStudent().equals(that.getStudent()) && getProgram().equals(that.getProgram()) && getRegisterDate().equals(that.getRegisterDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentHasProgramKey(), getStudent(), getProgram(), getRegisterDate());
    }
}
