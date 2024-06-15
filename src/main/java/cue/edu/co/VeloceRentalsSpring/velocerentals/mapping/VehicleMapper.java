package cue.edu.co.VeloceRentalsSpring.velocerentals.mapping;


import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.VehicleDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Vehicle;

/**
 * This class is responsible for mapping between Vehicle DTO and Vehicle Model.
 * It provides methods to convert between these two representations.
 */
public class VehicleMapper {

    /**
     * Maps a VehicleDto object to a Vehicle object.
     *
     * @param vehicleDto the VehicleDto object to be mapped
     * @return a Vehicle object with the same data as the input VehicleDto
     */
    public static Vehicle mapFromDTO(VehicleDto vehicleDto) {
        return Vehicle.builder()
                .id(vehicleDto.id())
                .pricePerDay(vehicleDto.pricePerDay())
                .type(vehicleDto.type())
                .brand(vehicleDto.brand())
                .model(vehicleDto.model())
                .year(vehicleDto.year())
                .availability(vehicleDto.availability())
                .build();
    }

    /**
     * Maps a Vehicle object to a VehicleDto object.
     *
     * @param vehicle the Vehicle object to be mapped
     * @return a VehicleDto object with the same data as the input Vehicle
     */
    public static VehicleDto mapFromModel(Vehicle vehicle) {
        return VehicleDto.builder()
                .id(vehicle.getId())
                .pricePerDay(vehicle.getPricePerDay())
                .type(vehicle.getType())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .year(vehicle.getYear())
                .availability(vehicle.getAvailability())
                .build();
    }
}
