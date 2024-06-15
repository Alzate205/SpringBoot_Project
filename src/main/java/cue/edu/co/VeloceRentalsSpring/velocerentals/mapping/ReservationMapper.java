package cue.edu.co.VeloceRentalsSpring.velocerentals.mapping;


import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.ReservationDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Reservation;

/**
 * This class is responsible for mapping between ReservationDto and Reservation model.
 * It provides methods to convert from DTO to model and vice versa.
 */
public class ReservationMapper {

    /**
     * Maps a ReservationDto object to a Reservation model object.
     *
     * @param reservationDto the ReservationDto object to be mapped
     * @return a Reservation model object
     */
    public static Reservation mapFromDTO(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.id())
                .user(reservationDto.user())
                .vehicle(reservationDto.vehicle())
                .startDate(reservationDto.startDate())
                .endDate(reservationDto.endDate())
                .totalCost(reservationDto.totalCost())
                .status(reservationDto.status())
                .build();
    }

    /**
     * Maps a Reservation model object to a ReservationDto object.
     *
     * @param reservation the Reservation model object to be mapped
     * @return a ReservationDto object
     */
    public static ReservationDto mapFromModel(Reservation reservation){
        return ReservationDto.builder()
               .id(reservation.getId())
               .user(reservation.getUser())
               .vehicle(reservation.getVehicle())
               .startDate(reservation.getStartDate())
               .endDate(reservation.getEndDate())
               .totalCost(reservation.getTotalCost())
               .status(reservation.getStatus())
               .build();
    }
}
