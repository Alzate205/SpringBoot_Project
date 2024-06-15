package cue.edu.co.VeloceRentalsSpring.velocerentals.services.implementations;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.TransactionDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.mapping.TransactionMapper;
import cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA.TransactionRepositoryJPA;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces.GenericService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for TransactionDto.
 * Provides CRUD operations and existence verification for transactions.
 */
@Service
public class TransactionServiceImpl implements GenericService<TransactionDto> {

    private final TransactionRepositoryJPA repository;

    @Autowired
    public TransactionServiceImpl(TransactionRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<TransactionDto> findAll() {
        return repository.findAll().stream().map(TransactionMapper::mapFromModel).toList();
    }

    @Override
    public TransactionDto findById(Long id) {
        return repository.findById(id)
                .map(TransactionMapper::mapFromModel)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));
    }

    @Override
    public void create(TransactionDto transactionDto) {
        repository.save(TransactionMapper.mapFromDTO(transactionDto));
    }

    @Override
    public void remove(Long id) {
        repository.delete(TransactionMapper.mapFromDTO(findById(id)));
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
