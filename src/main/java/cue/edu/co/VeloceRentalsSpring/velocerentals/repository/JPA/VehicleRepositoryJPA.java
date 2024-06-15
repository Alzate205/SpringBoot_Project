package cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositoryJPA extends JpaRepository<Vehicle, Long> {
}
