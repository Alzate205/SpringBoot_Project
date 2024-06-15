package cue.edu.co.VeloceRentalsSpring.velocerentals.services.interfaces;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.UserDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers() throws SQLException;
    UserDto getUserById(long id) throws SQLException;
    void addUser(UserDto user) throws SQLException;
    void removeUser(long id) throws SQLException;
    Boolean doesUserExist(long id) throws SQLException;
    Optional<UserDto> getUserByEmail(String email) throws SQLException;
}
