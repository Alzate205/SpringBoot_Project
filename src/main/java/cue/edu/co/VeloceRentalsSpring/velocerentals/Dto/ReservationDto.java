package cue.edu.co.VeloceRentalsSpring.velocerentals.Dto;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.User;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Vehicle;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
/**
 * This class represents a ReservationDto, which is used to transfer data between the application and the database.
 * It contains fields for reservation details such as user, vehicle, start and end dates, total cost, and status.
 *
 * @author Tabnine
 * @since 1.0
 */
@Builder
public record ReservationDto(
        /**
         * The unique identifier of the reservation.
         */
        Long id,

        /**
         * The user who made the reservation.
         * This field cannot be null.
         */
        @NotNull(message = "User can`t be null")
        User user,

        /**
         * The vehicle that is being reserved.
         * This field cannot be null.
         */
        @NotNull(message = "Vehicle can`t be null")
        Vehicle vehicle,

        /**
         * The start date of the reservation.
         * This field is annotated with @DateTimeFormat to support date formatting.
         */
        @DateTimeFormat
        LocalDate startDate,

        /**
         * The end date of the reservation.
         * This field is annotated with @DateTimeFormat to support date formatting.
         */
        @DateTimeFormat
        LocalDate endDate,

        /**
         * The total cost of the reservation.
         * This field cannot be null.
         */
        @NotNull(message = "Total cost can`t be null")
        double totalCost,

        /**
         * The status of the reservation.
         * This field represents the current state of the reservation (e.g., pending, confirmed, canceled).
         */
        int status) {
}
