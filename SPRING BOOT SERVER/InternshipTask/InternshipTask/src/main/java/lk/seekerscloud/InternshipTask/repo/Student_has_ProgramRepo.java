package lk.seekerscloud.InternshipTask.repo;

import lk.seekerscloud.InternshipTask.dto.query_interface.Student_has_ProgramDataInterface;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface Student_has_ProgramRepo extends JpaRepository<Student_has_Program,String>{
    @Query(value = "SELECT * FROM student_has_program WHERE student_id=?1 OR program_id=?1 OR registerDate=?1",nativeQuery = true)
    Page<Student_has_ProgramDataInterface> loadAllStudent_has_Programs(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM student_has_program WHERE student_id=?1 OR program_id=?1 OR registerDate=?1",nativeQuery = true)
    int loadAllStudent_has_ProgramsCount(String searchText);

    @Query(value = "SELECT * FROM student_has_program WHERE student_id=?1",nativeQuery = true)
    Student_has_Program loadByStudentId(String id);
    @Query(value = "SELECT * FROM student_has_program WHERE program_id=?1",nativeQuery = true)
    Student_has_Program loadByProgramId(String id);

}
