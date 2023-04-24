package lk.seekerscloud.InternshipTask.service;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedStudentResponseDto;
import lk.seekerscloud.InternshipTask.dto.query_interface.StudentDataInterface;
import lk.seekerscloud.InternshipTask.dto.request.ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.request.StudentRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.ProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;

public interface ProgramService {
    public String saveProgram(ProgramRequestDto dto);
    public void deleteProgram(String id);
    public ProgramResponseDto findProgram(String id);
    public String updateProgram(String id,ProgramRequestDto dto);
    public PaginatedProgramResponseDto listAllPrograms(String searchText, int page, int pageSize);
}
