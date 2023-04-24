package lk.seekerscloud.InternshipTask.dto.response;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
public class StudentResponseDto {
    private String id;
    private String name;
    private String address;
    private String contact;
    private List<Student_has_Program> studentHasPrograms;
}
