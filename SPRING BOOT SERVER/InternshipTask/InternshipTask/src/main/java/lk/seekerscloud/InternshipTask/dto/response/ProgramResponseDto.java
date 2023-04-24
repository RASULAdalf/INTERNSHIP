package lk.seekerscloud.InternshipTask.dto.response;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramResponseDto {
    private String id;
    private String name;
    private String duration;
    private double cost;
    private List<Student_has_Program> studentHasPrograms;
}
