package cue.edu.co.VeloceRentalsSpring.velocerentals.model.models;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.Availability;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double pricePerDay;
    @Enumerated
    private VehicleType type;
    private String brand;
    private String model;
    private int year;
    @Enumerated
    private Availability availability;
}
