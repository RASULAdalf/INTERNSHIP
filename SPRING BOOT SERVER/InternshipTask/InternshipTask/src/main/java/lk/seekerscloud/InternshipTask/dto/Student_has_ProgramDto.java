package lk.seekerscloud.InternshipTask.dto;

import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.entity.Student_has_ProgramKey;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student_has_ProgramDto {
    private Student student;
    private Program program;
    private String registerDate;
}
