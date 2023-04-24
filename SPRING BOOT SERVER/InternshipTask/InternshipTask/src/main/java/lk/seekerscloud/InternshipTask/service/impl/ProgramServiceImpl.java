package lk.seekerscloud.InternshipTask.service.impl;

import lk.seekerscloud.InternshipTask.dto.paginate.PaginatedProgramResponseDto;
import lk.seekerscloud.InternshipTask.dto.request.ProgramRequestDto;
import lk.seekerscloud.InternshipTask.dto.response.ProgramResponseDto;
import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.repo.ProgramRepo;
import lk.seekerscloud.InternshipTask.service.ProgramService;
import lk.seekerscloud.InternshipTask.util.GeneratedIDDto;
import lk.seekerscloud.InternshipTask.util.IdGenerator;
import lk.seekerscloud.InternshipTask.util.mapper.ProgramMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepo programRepo;
    private final ProgramMapper mapper;
    private final IdGenerator generator;

    public ProgramServiceImpl(ProgramRepo programRepo, ProgramMapper mapper, IdGenerator generator) {
        this.programRepo = programRepo;
        this.mapper = mapper;
        this.generator = generator;
    }

    @Override
    public String saveProgram(ProgramRequestDto dto) {
        GeneratedIDDto generatedIDDto = this.generator.generateId(5);
        Program program = this.mapper.toProgram(dto);
        //program.setId("P - "+generatedIDDto.getGeneratedId());
        return this.programRepo.save(program).getId();
    }

    @Override
    public void deleteProgram(String id) {
        this.programRepo.deleteById(id);
    }

    @Override
    public ProgramResponseDto findProgram(String id) {
        Optional<Program> byId = this.programRepo.findById(id);
        if (byId.isPresent()){
            Program program = byId.get();
            program.setStudentHasPrograms(this.programRepo.getProgramEntries(id));
            return this.mapper.toProgramResponseDto(program);
        }
        return null;
    }

    @Override
    public String updateProgram(String id, ProgramRequestDto dto) {
        Optional<Program> byId = this.programRepo.findById(id);
        if (byId.isPresent()){
            Program program = this.mapper.toProgram(dto);
            program.setId(byId.get().getId());
            return this.programRepo.save(program).getId();
        }
        return "Program not found!";
    }

    @Override
    public PaginatedProgramResponseDto listAllPrograms(String searchText, int page, int pageSize) {
        List<ProgramResponseDto> programResponseDtos = this.mapper.toProgramResponseDtoList(this.programRepo.loadAllPrograms(searchText, PageRequest.of(page, pageSize)));
        for (int i = 0; i < programResponseDtos.size(); i++) {
            programResponseDtos.get(i).setStudentHasPrograms(this.programRepo.getProgramEntries(programResponseDtos.get(i).getId()));
        }
        return new PaginatedProgramResponseDto(programResponseDtos,this.programRepo.loadAllProgramsCount(searchText));
    }
}
