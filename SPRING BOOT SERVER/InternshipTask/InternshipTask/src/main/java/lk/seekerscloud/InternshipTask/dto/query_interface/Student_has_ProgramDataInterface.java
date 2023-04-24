package lk.seekerscloud.InternshipTask.dto.query_interface;

import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;

public interface Student_has_ProgramDataInterface {

    Student getStudent();
    Program getProgram();
    String getRegisterDate();
}
