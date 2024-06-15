package cue.edu.co.VeloceRentalsSpring.velocerentals.controllers;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.ReservationDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.serviceImpl.ReservationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a controller for handling reservation related operations.
 * It uses Spring MVC annotations to map HTTP requests to methods.
 */
@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    /**
     * Autowired instance of ReservationServiceImpl.
     */
    @Autowired
    private ReservationServiceImpl reservationService;

    /**
     * This method handles HTTP GET requests to /show-reservations.
     * It retrieves all reservations from the database and returns them as a list of ReservationDto.
     *
     * @return a list of ReservationDto
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/show-reservations")
    public List<ReservationDto> getTransaction() throws SQLException {
        return reservationService.findAll();
    }

    /**
     * This method handles HTTP GET requests to /get-reservation/{id}.
     * It retrieves a reservation by its id from the database and returns it as a ReservationDto.
     *
     * @param id the id of the reservation to retrieve
     * @return a ReservationDto
     */
    @GetMapping(value = "/get-reservation/{id}")
    public ReservationDto getById(@PathVariable @Valid Long id) {
        return reservationService.findById(id);
    }

    /**
     * This method handles HTTP POST requests to /save-reservation.
     * It saves a new reservation to the database.
     *
     * @param reservationDto the reservation data to save
     * @param bindingResult the result of the validation of the reservation data
     * @return a map with a success message if the reservation is saved successfully,
     *         or a map with field errors if the validation fails
     */
    @PostMapping(value = "/save-reservation")
    public Map<String, String> saveReservation(@RequestBody @Valid ReservationDto reservationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    er -> errors.put(er.getField(), er.getDefaultMessage())
            );
            return errors;
        }
        reservationService.create(reservationDto);
        return Map.of("message", "Reservation added successfully");
    }

    /**
     * This method handles HTTP DELETE requests to /delete-reservation/{id}.
     * It deletes a reservation by its id from the database.
     *
     * @param id the id of the reservation to delete
     */
    @DeleteMapping(value = "/delete-reservation/{id}")
    public void deleteReservation(@PathVariable @Valid Long id) {
        reservationService.remove(id);
    }
}