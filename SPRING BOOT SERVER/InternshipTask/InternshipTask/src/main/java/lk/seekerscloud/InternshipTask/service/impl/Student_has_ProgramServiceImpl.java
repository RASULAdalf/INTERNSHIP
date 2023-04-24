package lk.seekerscloud.InternshipTask.service.impl;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedStudent_has_ProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.request.Student_has_ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.Student_has_ProgramResponseDto;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lk.seekerscloud.InternshipTask.repo.Student_has_ProgramRepo;
import lk.seekerscloud.InternshipTask.service.Student_has_ProgramService;
import lk.seekerscloud.InternshipTask.util.mapper.Student_has_ProgramMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Student_has_ProgramServiceImpl implements Student_has_ProgramService {
    private final Student_has_ProgramRepo student_has_programRepo;
    private final Student_has_ProgramMapper mapper;

    public Student_has_ProgramServiceImpl(Student_has_ProgramRepo student_has_programRepo, Student_has_ProgramMapper mapper) {
        this.student_has_programRepo = student_has_programRepo;
        this.mapper = mapper;
    }

    @Override
    public String saveStudent_has_Program(Student_has_ProgramRequestDto dto) {
        System.out.println(dto);
//        Student_has_Program student_has_program = new Student_has_Program(dto.getStudent().getId(),dto.getProgram().getId(),dto.getRegisterDate());
        this.student_has_programRepo.save(this.mapper.toStudent_has_Program(dto));
        return "Saved!";
    }

    @Override
    public void deleteStudent_has_Program(String id) {
        this.student_has_programRepo.deleteById(id);
    }

    @Override
    public Student_has_ProgramResponseDto findStudent_has_Program(String id) {
        Optional<Student_has_Program> byId = this.student_has_programRepo.findById(id);
        return (byId.isPresent())? this.mapper.toStudent_has_ProgramResponseDto(byId.get()):null;
    }

    @Override
    public String updateStudent_has_Program(String id, Student_has_ProgramRequestDto dto) {
        if (id.startsWith("S")){
            Student_has_Program studentHasProgram = this.student_has_programRepo.loadByStudentId(id);
            if (studentHasProgram!=null){
                studentHasProgram = this.mapper.toStudent_has_Program(dto);
                this.student_has_programRepo.save(studentHasProgram);
                return "Updated!";
            }else {
                return "Student not found!";
            }
        } else if (id.startsWith("P")) {
            Student_has_Program studentHasProgram = this.student_has_programRepo.loadByProgramId(id);
            if (studentHasProgram!=null){
                studentHasProgram = this.mapper.toStudent_has_Program(dto);
                this.student_has_programRepo.save(studentHasProgram);
                return "Updated!";
            }else {
                return "Program not found!";
            }
        }else {
            return "Wrong input!";
        }
    }

    @Override
    public PaginatedStudent_has_ProgramResponseDto listAllStudent_has_Programs(String searchText, int page, int pageSize) {
        return new PaginatedStudent_has_ProgramResponseDto(this.mapper.toStudent_has_ProgramResponseDtoList(this.student_has_programRepo.loadAllStudent_has_Programs(searchText, PageRequest.of(page,pageSize))),this.student_has_programRepo.loadAllStudent_has_ProgramsCount(searchText));
    }
}
