package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.backend.struct.Subproject;

import java.util.List;

public interface SubprojectRepository extends JpaRepository<Subproject, Long> {

   List<Subproject> findByProject_Id(Long id);
}
