package cue.edu.co.VeloceRentalsSpring.velocerentals.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a login request with email and password.
 * This class is used to encapsulate the data required for user login.
 *
 * @author YourName
 * @version 1.0
 * @since 2023-01-01
 */
public record Login(
        /**
         * The email of the user.
         * It is required and must be a valid email address.
         */
        @NotBlank(message = "Email is required")
        @Email(message = "Must be a valid email address")
        String email,

        /**
         * The password of the user.
         * It is required and should not be empty.
         */
        @NotBlank(message = "Password is required")
        String password) {
}
