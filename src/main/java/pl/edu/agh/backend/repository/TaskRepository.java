package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.backend.struct.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

   List<Task> findBySubproject_Id(Long id);

   List<Task> findByAssignedTo_Username(String username);
}
