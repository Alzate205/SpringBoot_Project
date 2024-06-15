package cue.edu.co.VeloceRentalsSpring.velocerentals.model.models;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.PayMethods;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn( name = "reservation_id")
    private Reservation reservation;
    private double amount;
    private LocalDateTime dateTime;
    @Enumerated
    private PayMethods payMethods;
    private int status;
}
