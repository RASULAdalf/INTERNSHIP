package lk.seekerscloud.InternshipTask.dto;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
public class ProgramDto {
    private String id;
    private String name;
    private String duration;
    private double cost;
    private List<Student_has_Program> studentHasPrograms;
}
