package lk.seekerscloud.InternshipTask.dto.paginate;

import lk.seekerscloud.InternshipTask.dto.response.ProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedProgramResponseDto {
    private List<ProgramResponseDto> list;
    private long dataCount;
}
