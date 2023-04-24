package lk.seekerscloud.InternshipTask.controller;

import lk.seekerscloud.InternshipTask.dto.request.ProgramRequestDto;
import lk.seekerscloud.InternshipTask.service.ProgramService;
import lk.seekerscloud.InternshipTask.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/program")
@CrossOrigin
public class ProgramController {
    @Autowired
    private ProgramService programService;
    @PostMapping
    public ResponseEntity<StandardResponse> saveProgram(@RequestBody ProgramRequestDto dto){
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"ProgramSaved", programService.saveProgram(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateProgram(@RequestParam String id,@RequestBody ProgramRequestDto dto){
        return new ResponseEntity<>(new StandardResponse(200,"Program Updated!", programService.updateProgram(id,dto)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteProgram(@RequestParam String id){
        programService.deleteProgram(id);
        return new ResponseEntity<>(new StandardResponse(200,"Program Deleted!",null),HttpStatus.OK);
    }

    @GetMapping(path = "/find",params = {"id"})
    public ResponseEntity<StandardResponse> findProgramById(@RequestParam(value = "id") String id){
        return new ResponseEntity<>(new StandardResponse(200,"Program Found!", programService.findProgram(id)),HttpStatus.OK);
    }

    @GetMapping(path = "/list",params = {"searchText","page","size"})
    public ResponseEntity<StandardResponse> listAllCustomers(@RequestParam(value = "searchText") String searchText,@RequestParam(value = "page") int page,@RequestParam(value = "size") @Max(50) int size){
        return new ResponseEntity<>(new StandardResponse(200,"Program List ! ", programService.listAllPrograms(searchText, page, size)), HttpStatus.OK);
    }

}
