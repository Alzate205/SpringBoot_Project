package cue.edu.co.VeloceRentalsSpring.velocerentals.Dto;

import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Reservation;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.enums.PayMethods;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
/**
 * This class represents a TransactionDto, which is used to transfer data between the application and the database.
 * It contains fields for transaction details such as id, reservation, amount, dateTime, payMethods, and status.
 *
 * @author YourName
 * @version 1.0
 * @since 2023-01-01
 */
@Builder
public record TransactionDto(
        /**
         * The unique identifier of the transaction.
         */
        Long id,

        /**
         * The reservation associated with the transaction.
         * This field cannot be null.
         */
        @NotNull(message = "Reservation can't be null'")
        Reservation reservation,

        /**
         * The amount of the transaction.
         * This field cannot be null.
         */
        @NotNull(message = "Amount can't be null")
        double amount,

        /**
         * The date and time of the transaction.
         * This field cannot be null.
         */
        @NotNull(message = "DateTime can't be null'")
        LocalDateTime dateTime,

        /**
         * The payment method used for the transaction.
         */
        PayMethods payMethods,

        /**
         * The status of the transaction.
         * This field represents the transaction's current state.
         */
        int status) {
}
