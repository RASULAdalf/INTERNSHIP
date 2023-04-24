package lk.seekerscloud.InternshipTask.util.mapper;

import lk.seekerscloud.InternshipTask.dto.StudentDto;
import lk.seekerscloud.InternshipTask.dto.query_interface.StudentDataInterface;
import lk.seekerscloud.InternshipTask.dto.request.StudentRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.StudentResponseDto;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentRequestDto dto);
    StudentDto toStudentDto(Student student);
    List<StudentResponseDto> toStudentResponseDtoList(Page<StudentDataInterface> list);
    StudentResponseDto toStudentResponseDto(Student student);

//    default List<StudentResponseDto> toStudentResponseDtoList(Page<StudentDataInterface> list){
//        if ( list == null ) {
//            return null;
//        }
//
//        List<StudentResponseDto> list1 = new ArrayList<StudentResponseDto>();
//        for ( StudentDataInterface studentDataInterface : list ) {
//            if ( studentDataInterface == null ) {
//                return null;
//            }
//
//            StudentResponseDto studentResponseDto = new StudentResponseDto();
//
//            studentResponseDto.setId( studentDataInterface.getId() );
//            studentResponseDto.setName( studentDataInterface.getName() );
//            studentResponseDto.setAddress( studentDataInterface.getAddress() );
//            studentResponseDto.setContact( studentDataInterface.getContact() );
//            List<Student_has_Program> list3 = studentDataInterface.getStudentHasPrograms();
//            if ( list3 != null ) {
//                studentResponseDto.setStudentHasPrograms( new ArrayList<Student_has_Program>( list3 ) );
//            }
//            list1.add( studentResponseDto );
//        }
//
//        return list1;
//    }
}
