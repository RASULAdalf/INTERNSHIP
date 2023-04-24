package lk.seekerscloud.InternshipTask.controller;

import lk.seekerscloud.InternshipTask.dto.request.Student_has_ProgramRequestDto;
import lk.seekerscloud.InternshipTask.service.Student_has_ProgramService;
import lk.seekerscloud.InternshipTask.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/student_has_program")
@CrossOrigin
public class Student_has_ProgramController {
    @Autowired
    private Student_has_ProgramService student_has_programService;
    @PostMapping
    public ResponseEntity<StandardResponse> saveStudent_has_Program(@RequestBody Student_has_ProgramRequestDto dto){
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Student_has_ProgramSaved", student_has_programService.saveStudent_has_Program(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateStudent_has_Program(@RequestParam String id,@RequestBody Student_has_ProgramRequestDto dto){
        return new ResponseEntity<>(new StandardResponse(200,"Student_has_Program Updated!", student_has_programService.updateStudent_has_Program(id,dto)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteStudent_has_Program(@RequestParam String id){
        student_has_programService.deleteStudent_has_Program(id);
        return new ResponseEntity<>(new StandardResponse(200,"Student_has_Program Deleted!",null),HttpStatus.OK);
    }

    @GetMapping(path = "/find",params = {"id"})
    public ResponseEntity<StandardResponse> findStudent_has_ProgramById(@RequestParam(value = "id") String id){
        return new ResponseEntity<>(new StandardResponse(200,"Student_has_Program Found!", student_has_programService.findStudent_has_Program(id)),HttpStatus.OK);
    }

    @GetMapping(path = "/list",params = {"searchText","page","size"})
    public ResponseEntity<StandardResponse> listAllCustomers(@RequestParam(value = "searchText") String searchText,@RequestParam(value = "page") int page,@RequestParam(value = "size") @Max(50) int size){
        return new ResponseEntity<>(new StandardResponse(200,"Student_has_Program List ! ", student_has_programService.listAllStudent_has_Programs(searchText, page, size)), HttpStatus.OK);
    }

}
