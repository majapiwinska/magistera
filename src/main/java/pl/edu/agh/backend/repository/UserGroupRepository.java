package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.backend.struct.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
