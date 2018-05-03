package pl.edu.agh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.backend.struct.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   public User findOneByUsername(String username);
}
