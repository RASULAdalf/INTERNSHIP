package lk.seekerscloud.InternshipTask.dto.request;

import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.entity.Student_has_ProgramKey;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student_has_ProgramRequestDto {
    private Student student;
    private Program program;
    private String registerDate;
}
