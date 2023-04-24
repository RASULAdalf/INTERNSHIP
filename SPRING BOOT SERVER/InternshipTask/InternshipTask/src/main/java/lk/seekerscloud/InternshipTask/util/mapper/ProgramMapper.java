package lk.seekerscloud.InternshipTask.util.mapper;

import lk.seekerscloud.InternshipTask.dto.ProgramDto;
import lk.seekerscloud.InternshipTask.dto.query_interface.ProgramDataInterface;
import lk.seekerscloud.InternshipTask.dto.request.ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.ProgramResponseDto;
import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {
    Program toProgram(ProgramRequestDto dto);
    ProgramDto toProgramDto(Program program);
    List<ProgramResponseDto> toProgramResponseDtoList(Page<ProgramDataInterface> list);
    ProgramResponseDto toProgramResponseDto(Program Program);
//        default List<ProgramResponseDto> toProgramResponseDtoList(Page<ProgramDataInterface> list){
//        if ( list == null ) {
//            return null;
//        }
//
//        List<ProgramResponseDto> list1 = new ArrayList<ProgramResponseDto>();
//        for ( ProgramDataInterface programDataInterface : list ) {
//            if ( programDataInterface == null ) {
//                return null;
//            }
//
//            ProgramResponseDto programResponseDto = new ProgramResponseDto();
//
//            programResponseDto.setId( programDataInterface.getId() );
//            programResponseDto.setName( programDataInterface.getName() );
//            programResponseDto.setDuration( programDataInterface.getDuration() );
//            programResponseDto.setCost( programDataInterface.getCost() );
//            List<Student_has_Program> list3 = programDataInterface.getStudentHasPrograms();
//            if ( list3 != null ) {
//                programResponseDto.setStudentHasPrograms( new ArrayList<Student_has_Program>( list3 ) );
//            }
//            list1.add(programResponseDto);
//        }
//
//        return list1;
//    }
}
