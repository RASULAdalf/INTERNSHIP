package lk.seekerscloud.InternshipTask.dto.query_interface;

import lk.seekerscloud.InternshipTask.entity.Student_has_Program;

import java.util.List;
import java.util.Set;
import lombok.Data;

public interface StudentDataInterface {
    String getId();
    String getName();
    String getAddress();
    String getContact();
    List<Student_has_Program> getStudentHasPrograms();
}
