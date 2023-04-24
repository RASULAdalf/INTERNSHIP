package lk.seekerscloud.InternshipTask.dto.paginate;

import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStudentResponseDto {
    private List<StudentResponseDto> list;
    private long dataCount;
}
