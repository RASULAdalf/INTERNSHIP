package lk.seekerscloud.InternshipTask.controller;

import lk.seekerscloud.InternshipTask.dto.request.StudentRequestDto;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.service.StudentService;
import lk.seekerscloud.InternshipTask.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentRequestDto dto){
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"StudentSaved",studentService.saveStudent(dto)), HttpStatus.CREATED);
    }
    @PostMapping(path = "/assign")
    public ResponseEntity<StandardResponse> assignStudentToProgram(@RequestBody StudentRequestDto dto){
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Student Assigned!",studentService.assignToProgram(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateStudent(@RequestParam String id,@RequestBody StudentRequestDto dto){
        return new ResponseEntity<>(new StandardResponse(200,"Student Updated!",studentService.updateStudent(id,dto)),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteStudent(@RequestParam String id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(new StandardResponse(200,"Student Deleted!",null),HttpStatus.OK);
    }

    @GetMapping(path = "/find",params = {"id"})
    public ResponseEntity<StandardResponse> findStudentById(@RequestParam(value = "id") String id){
        return new ResponseEntity<>(new StandardResponse(200,"Student Found!",studentService.findStudent(id)),HttpStatus.OK);
    }

    @GetMapping(path = "/list",params = {"searchText","page","size"})
    public ResponseEntity<StandardResponse> listAllCustomers(@RequestParam(value = "searchText") String searchText,@RequestParam(value = "page") int page,@RequestParam(value = "size") @Max(50) int size){
        return new ResponseEntity<>(new StandardResponse(200,"Student List ! ",studentService.listAllStudents(searchText, page, size)), HttpStatus.OK);
    }

}
