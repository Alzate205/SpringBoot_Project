package cue.edu.co.VeloceRentalsSpring.velocerentals.controllers;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.VehicleDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.serviceImpl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * This class is responsible for handling HTTP requests related to vehicles.
 * It uses a VehicleServiceImpl to perform CRUD operations on VehicleDto objects.
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleServiceImpl vehicleService;
private
    /**
     * Retrieves all vehicles from the database.
     *
     * @return A list of VehicleDto objects.
     */
    @GetMapping("/all")
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.findAll();
    }

    /**
     * Retrieves a vehicle by its id.
     *
     * @param id The id of the vehicle to retrieve.
     * @return A VehicleDto object.
     */
    @GetMapping("/{id}")
    public VehicleDto getVehicleById(@PathVariable Long id) {
        return vehicleService.findById(id);
    }




    /**
     * Adds a new vehicle to the database.
     *
     * @param vehicle The VehicleDto object to add.
     * @param bindingResult The BindingResult object to check for validation errors.
     * @return A map with a success message if the vehicle is added successfully, or a map with field errors if there are validation errors.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@Valid @RequestBody VehicleDto vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }
        vehicleService.create(vehicle);
        return ResponseEntity.ok("Vehicle added successfully");
    }

    /**
     * Deletes a vehicle from the database.
     *
     * @param id The id of the vehicle to delete.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.remove(id);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }
}
