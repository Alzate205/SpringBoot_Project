package cue.edu.co.VeloceRentalsSpring.velocerentals.services.serviceImpl;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.ReservationDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.mapping.ReservationMapper;
import cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA.ReservationRepositoryJPA;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of GenericService interface for handling ReservationDto objects.
 */
@Service
public class ReservationServiceImpl implements GenericService<ReservationDto> {

    private final ReservationRepositoryJPA reservationRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepositoryJPA reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    /**
     * Retrieves all ReservationDto objects from the repository.
     *
     * @return a list of ReservationDto objects
     */
    @Override
    public List<ReservationDto> findAll() {
        return reservationRepo.findAll().stream()
                .map(ReservationMapper::mapFromModel)
                .toList();
    }

    /**
     * Retrieves a ReservationDto object by its ID from the repository.
     *
     * @param id the ID of the ReservationDto to retrieve
     * @return the ReservationDto with the given ID
     * @throws EntityNotFoundException if no ReservationDto with the given ID is found
     */
    @Override
    public ReservationDto findById(Long id) {
        return reservationRepo.findById(id)
                .map(ReservationMapper::mapFromModel)
                .orElseThrow(() -> new EntityNotFoundException("No reservation found with ID: " + id));
    }

    /**
     * Saves a new or updated ReservationDto object to the repository.
     *
     * @param reservationDto the ReservationDto to save
     */
    @Override
    public void create(ReservationDto reservationDto) {
        reservationRepo.save(ReservationMapper.mapFromDTO(reservationDto));
    }

    /**
     * Deletes a ReservationDto object from the repository by its ID.
     *
     * @param id the ID of the ReservationDto to delete
     */
    @Override
    public void remove(Long id) {
        reservationRepo.delete(ReservationMapper.mapFromDTO(findById(id)));
    }

    /**
     * Checks if a ReservationDto object with the given ID exists in the repository.
     *
     * @param id the ID of the ReservationDto to check
     * @return true if a ReservationDto with the given ID exists, false otherwise
     */
    @Override
    public Boolean existsById(Long id) {
        return reservationRepo.existsById(id);
    }
}
