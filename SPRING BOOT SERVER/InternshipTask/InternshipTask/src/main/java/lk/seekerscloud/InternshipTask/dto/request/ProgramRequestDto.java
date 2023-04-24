package lk.seekerscloud.InternshipTask.dto.request;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramRequestDto {
    private String id;
    private String name;
    private String duration;
    private double cost;
    private List<Student_has_Program> studentHasPrograms;
}
