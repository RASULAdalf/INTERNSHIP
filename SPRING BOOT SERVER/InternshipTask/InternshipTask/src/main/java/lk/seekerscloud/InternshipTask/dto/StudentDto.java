package lk.seekerscloud.InternshipTask.dto;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
public class StudentDto {
    private String id;
    private String name;
    private String address;
    private String contact;
    private List<Student_has_Program> studentHasPrograms;
}
