package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.backend.struct.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Role findByName(String name);
}
