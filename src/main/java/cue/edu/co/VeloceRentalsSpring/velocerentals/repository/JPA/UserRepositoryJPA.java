package cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
