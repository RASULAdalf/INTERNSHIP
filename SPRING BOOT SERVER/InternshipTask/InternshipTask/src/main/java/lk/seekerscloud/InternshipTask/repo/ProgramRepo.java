package lk.seekerscloud.InternshipTask.repo;

import lk.seekerscloud.InternshipTask.dto.query_interface.ProgramDataInterface;
import lk.seekerscloud.InternshipTask.dto.query_interface.StudentDataInterface;
import lk.seekerscloud.InternshipTask.entity.Program;
import lk.seekerscloud.InternshipTask.entity.Student;
import lk.seekerscloud.InternshipTask.entity.Student_has_Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProgramRepo extends JpaRepository<Program,String> {
    @Query(value = "SELECT p FROM Program p WHERE p.name LIKE %:searchText%")
    Page<ProgramDataInterface> loadAllPrograms(@Param("searchText") String searchText, Pageable pageable);
    @Query(value = "SELECT count(p) FROM Program p WHERE p.name LIKE %:searchText%")
    int loadAllProgramsCount(@Param("searchText") String searchText);

    @Query(value = "SELECT * FROM student_has_program Where student_id=?1",nativeQuery = true)
    List<Student_has_Program> getProgramEntries(String searchText);


}
