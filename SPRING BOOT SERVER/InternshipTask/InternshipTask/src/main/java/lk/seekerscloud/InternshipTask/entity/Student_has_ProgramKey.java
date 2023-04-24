package lk.seekerscloud.InternshipTask.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Student_has_ProgramKey implements Serializable {

    private String studentId;
    private String programId;
}
