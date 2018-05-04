package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.backend.struct.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

   Project findByName(String name);
}
