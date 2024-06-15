package cue.edu.co.VeloceRentalsSpring.velocerentals.Dto;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.Availability;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.VehicleType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * This class represents a Vehicle DTO (Data Transfer Object) used for data transfer between the application and the client.
 * It contains fields for vehicle details and uses the Record feature introduced in Java 14.
 *
 * @author YourName
 * @version 1.0
 * @since 2023-01-01
 */
@Builder
public record VehicleDto(
        /**
         * Unique identifier for the vehicle.
         */
        Long id,

        /**
         * Price per day for renting the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Price per day can't be null")
        double pricePerDay,

        /**
         * Type of the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Type can't be null")
        VehicleType type,

        /**
         * Brand of the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Brand can't be null")
        String brand,

        /**
         * Model of the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Model can't be null")
        String model,

        /**
         * Year of manufacture of the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Year can't be null")
        int year,

        /**
         * Availability status of the vehicle.
         * This field cannot be null.
         */
        @NotNull(message = "Availability can't be null")
        Availability availability) {
}
