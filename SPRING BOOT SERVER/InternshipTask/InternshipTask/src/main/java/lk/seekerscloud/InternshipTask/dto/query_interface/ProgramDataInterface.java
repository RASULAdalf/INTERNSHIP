package lk.seekerscloud.InternshipTask.dto.query_interface;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;

import java.util.List;

public interface ProgramDataInterface {
    String getId();
    String getName();
    String getDuration();
    double getCost();
    List<Student_has_Program> getStudentHasPrograms();
}
