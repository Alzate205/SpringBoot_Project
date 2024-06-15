package cue.edu.co.VeloceRentalsSpring.velocerentals.services.serviceImpl;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.VehicleDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.mapping.VehicleMapper;
import cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA.VehicleRepositoryJPA;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for VehicleDto.
 * Provides CRUD operations and existence verification for vehicles.
 */
@Service
public class VehicleServiceImpl implements GenericService<VehicleDto> {

    private final VehicleRepositoryJPA repository;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<VehicleDto> findAll() {
        return repository.findAll().stream().map(VehicleMapper::mapFromModel).toList();
    }

    @Override
    public VehicleDto findById(Long id) {
        return repository.findById(id)
                .map(VehicleMapper::mapFromModel)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id: " + id));
    }

    @Override
    public void create(VehicleDto vehicleDto) {
        repository.save(VehicleMapper.mapFromDTO(vehicleDto));
    }

    @Override
    public void remove(Long id) {
        repository.delete(VehicleMapper.mapFromDTO(findById(id)));
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
