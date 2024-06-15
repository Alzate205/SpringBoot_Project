package cue.edu.co.VeloceRentalsSpring.velocerentals.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * This class represents a UserDto object. It is used to transfer data between the application and the database.
 * It uses the Record feature introduced in Java 14, which allows for immutable data classes.
 *
 * @author YourName
 * @version 1.0
 * @since 2023-01-01
 */
@Builder
public record UserDto(
    /**
     * Unique identifier for the user.
     */
    long id,

    /**
     * User's first name. Cannot be null or empty.
     */
    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede estar vacío")
    String name,

    /**
     * User's last name. Cannot be null or empty.
     */
    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede estar vacío")
    String lastName,

    /**
     * User's username. Cannot be null or empty.
     */
    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "No puede estar en blanco")
    String username,

    /**
     * User's password. Cannot be null or empty.
     */
    @NotBlank(message = "Password is required")
    @NotNull(message = "No puede ser nulo")
    String password,

    /**
     * User's email address. Must be a valid email address. Cannot be null or empty.
     */
    @Email
    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email address")
    String email,

    /**
     * User's status. Cannot be null.
     */
    @NotNull(message = "No puede ser nulo")
    int status
) {
    // Additional methods and logic can be added here if needed.
}
