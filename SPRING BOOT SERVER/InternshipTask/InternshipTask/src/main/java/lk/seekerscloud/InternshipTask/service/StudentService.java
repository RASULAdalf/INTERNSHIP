package lk.seekerscloud.InternshipTask.service;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedStudentResponseDto;
import lk.seekerscloud.InternshipTask.dto.query_interface.StudentDataInterface;
import lk.seekerscloud.InternshipTask.dto.request.StudentRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;
import lk.seekerscloud.InternshipTask.entity.Student;

public interface StudentService {
    public String saveStudent(StudentRequestDto dto);
    public void deleteStudent(String id);
    public StudentResponseDto findStudent(String id);
    public String updateStudent(String id,StudentRequestDto dto);
    Student assignToProgram(StudentRequestDto dto);
    public PaginatedStudentResponseDto listAllStudents(String searchText,int page,int pageSize);
}
