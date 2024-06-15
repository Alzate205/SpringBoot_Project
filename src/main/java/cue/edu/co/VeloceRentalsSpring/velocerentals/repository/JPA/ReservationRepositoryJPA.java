package cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepositoryJPA extends JpaRepository<Reservation, Long> {
}
