package lk.seekerscloud.InternshipTask.util.mapper;

import lk.seekerscloud.InternshipTask.dto.Student_has_ProgramDto;
import lk.seekerscloud.InternshipTask.dto.query_interface.Student_has_ProgramDataInterface;
import lk.seekerscloud.InternshipTask.dto.request.Student_has_ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.Student_has_ProgramResponseDto;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface Student_has_ProgramMapper {
    Student_has_Program toStudent_has_Program(Student_has_ProgramRequestDto dto);
    Student_has_ProgramDto toStudent_has_ProgramDto(Student_has_Program student_has_program);
    List<Student_has_ProgramResponseDto> toStudent_has_ProgramResponseDtoList(Page<Student_has_ProgramDataInterface> list);
    Student_has_ProgramResponseDto toStudent_has_ProgramResponseDto(Student_has_Program student_has_program);
//    default List<Student_has_ProgramResponseDto> toStudent_has_ProgramResponseDtoList(Page<Student_has_ProgramDataInterface> list){
//        if ( list == null ) {
//            return null;
//        }
//
//        List<Student_has_ProgramResponseDto> list1 = new ArrayList<Student_has_ProgramResponseDto>();
//        for ( Student_has_ProgramDataInterface studentHasProgramDataInterface : list ) {
//            if ( studentHasProgramDataInterface == null ) {
//                return null;
//            }
//
//            Student_has_ProgramResponseDto studentHasProgramResponseDto = new Student_has_ProgramResponseDto();
//
//            studentHasProgramResponseDto.setStudent( studentHasProgramDataInterface.getStudent() );
//            studentHasProgramResponseDto.setProgram( studentHasProgramDataInterface.getProgram() );
//            studentHasProgramResponseDto.setRegisterDate( studentHasProgramDataInterface.getRegisterDate());
//
//            list1.add(studentHasProgramResponseDto);
//        }
//
//        return list1;
//    }
}
