package cue.edu.co.VeloceRentalsSpring.velocerentals.services.implementations;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.UserDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.mapping.UserMapper;
import cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA.UserRepositoryJPA;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for UserDto.
 * Provides CRUD operations and existence verification for users.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryJPA repository;

    @Autowired
    public UserServiceImpl(UserRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        return repository.findAll().stream().map(UserMapper::mapFromModel).toList();
    }

    @Override
    public UserDto getUserById(long id) throws SQLException {
        return repository.findById(id)
                .map(UserMapper::mapFromModel)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public void addUser(UserDto user) throws SQLException {
        repository.save(UserMapper.mapFromDTO(user));
    }

    @Override
    public void removeUser(long id) throws SQLException {
        repository.delete(UserMapper.mapFromDTO(getUserById(id)));
    }

    @Override
    public Boolean doesUserExist(long id) throws SQLException {
        return repository.existsById(id);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) throws SQLException {
        return Optional.ofNullable(repository.findByEmail(email))
                .map(UserMapper::mapFromModel);
    }
}
