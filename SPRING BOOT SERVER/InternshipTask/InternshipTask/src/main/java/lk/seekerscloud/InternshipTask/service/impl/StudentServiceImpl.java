package lk.seekerscloud.InternshipTask.service.impl;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedStudentResponseDto;
import lk.seekerscloud.InternshipTask.dto.request.StudentRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;
import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import lk.seekerscloud.InternshipTask.repo.ProgramRepo;
import lk.seekerscloud.InternshipTask.repo.StudentRepo;
import lk.seekerscloud.InternshipTask.repo.Student_has_ProgramRepo;
import lk.seekerscloud.InternshipTask.service.StudentService;
import lk.seekerscloud.InternshipTask.util.GeneratedIDDto;
import lk.seekerscloud.InternshipTask.util.IdGenerator;
import lk.seekerscloud.InternshipTask.util.mapper.StudentMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper mapper;
    private final IdGenerator generator;
    private final ProgramRepo programRepo;
    private final Student_has_ProgramRepo student_has_programRepo;


    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper mapper, IdGenerator generator, ProgramRepo programRepo, Student_has_ProgramRepo studentHasProgramRepo) {
        this.studentRepo = studentRepo;
        this.mapper = mapper;
        this.generator = generator;
        this.programRepo = programRepo;
        student_has_programRepo = studentHasProgramRepo;
    }

    @Override
    public String saveStudent(StudentRequestDto dto) {
        GeneratedIDDto generatedIDDto= this.generator.generateId(5);
        Student student = this.mapper.toStudent(dto);
        student.setId("S - "+generatedIDDto.getGeneratedId());
        return this.studentRepo.save(student).getId();
    }

    @Override
    public void deleteStudent(String id) {
        this.studentRepo.deleteById(id);
    }

    @Override
    public StudentResponseDto findStudent(String id) {
        Optional<Student> byId = this.studentRepo.findById(id);
        if (byId.isPresent()){
            StudentResponseDto studentResponseDto = this.mapper.toStudentResponseDto(byId.get());
            studentResponseDto.setStudentHasPrograms(this.studentRepo.getProgramEntries(id));
            return studentResponseDto;

        }
        return null;
    }

    @Override
    public String updateStudent(String id, StudentRequestDto dto) {
        Optional<Student> byId = this.studentRepo.findById(id);
        if (byId.isPresent()){
            Student student = this.mapper.toStudent(dto);
            student.setId(byId.get().getId());
            return this.studentRepo.save(student).getId();
        }
        return "Student not found!";
    }

    @Override
    public Student assignToProgram(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAddress(dto.getAddress());
        student.setContact(dto.getContact());
        student.setId(dto.getId());
        student.getStudentHasPrograms().addAll(dto.getStudentHasPrograms()
                .stream()
                .map(student_has_program -> {
                    Student_has_Program student_has_program1 = new Student_has_Program();
                    if (student_has_program.getProgram().getId()==null){
                        return null;
                    }
                    Optional<Program> byId = this.programRepo.findById(student_has_program.getProgram().getId());
                    if (!byId.isPresent()) {
                        return null;
                    }
                    student_has_program1.setProgram(byId.get());
                    student_has_program1.setStudent(student);
                    student_has_program1.setRegisterDate(student_has_program.getRegisterDate());
                    return student_has_program1;
                }).collect(Collectors.toList())
        );

        return this.studentRepo.save(student);
    }



    @Override
    public PaginatedStudentResponseDto listAllStudents(String searchText, int page, int pageSize) {
        List<StudentResponseDto> studentResponseDtos = this.mapper.toStudentResponseDtoList(this.studentRepo.loadAllStudents(searchText, PageRequest.of(page, pageSize)));
//        for (int i = 0; i < studentResponseDtos.size(); i++) {
//            studentResponseDtos.get(i).setStudentHasPrograms(this.studentRepo.getProgramEntries(studentResponseDtos.get(i).getId()));
//        }

        return new PaginatedStudentResponseDto(studentResponseDtos,this.studentRepo.loadAllStudentsCount(searchText));
    }
}
