package lk.seekerscloud.InternshipTask.dto.paginate;

import lk.seekerscloud.InternshipTask.dto.response.Student_has_ProgramResponseDto;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStudent_has_ProgramResponseDto {
    private List<Student_has_ProgramResponseDto> list;
    private long dataCount;
}
