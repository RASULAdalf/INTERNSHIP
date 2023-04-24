package lk.seekerscloud.InternshipTask.service;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedStudent_has_ProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.request.ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.request.Student_has_ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.ProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.response.Student_has_ProgramResponseDto;

public interface Student_has_ProgramService {
    public String saveStudent_has_Program(Student_has_ProgramRequestDto dto);
    public void deleteStudent_has_Program(String id);
    public Student_has_ProgramResponseDto findStudent_has_Program(String id);
    public String updateStudent_has_Program(String id,Student_has_ProgramRequestDto dto);
    public PaginatedStudent_has_ProgramResponseDto listAllStudent_has_Programs(String searchText, int page, int pageSize);

}
