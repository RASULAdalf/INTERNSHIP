package lk.seekerscloud.InternshipTask.dto.response;

import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student_has_ProgramResponseDto {
    private Student student;
    private Program program;
    private String registerDate;
}
