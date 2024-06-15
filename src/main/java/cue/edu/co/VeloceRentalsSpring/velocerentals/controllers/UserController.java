package cue.edu.co.VeloceRentalsSpring.velocerentals.controllers;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.Login;
import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

/**
 * This class is responsible for handling user-related requests.
 * It uses the UserService interface to interact with the user data.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    /**
     * UserService instance to perform user-related operations.
     */
    @Autowired
    private cue.edu.co.VeloceRentalsSpring.velocerentals.services.implementations.UserServiceImpl userService;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of UserDto objects
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/get-users")
    public List<UserDto> getUsers() throws SQLException {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the unique identifier of the user
     * @return a UserDto object if found, otherwise null
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/get-user/{id}")
    public UserDto getUser(@PathVariable @Valid Long id) throws SQLException {
        return userService.getUserById(id);
    }

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user
     * @return a UserDto object if found, otherwise null
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/get-user-by-email/{email}")
    public UserDto getUserByEmail(@PathVariable @Valid String email) throws SQLException {
        return userService.getUserByEmail(email).orElse(null);
    }

    /**
     * Saves a new user or updates an existing user.
     *
     * @param user the UserDto object to be saved or updated
     * @param bindingResult the result of the validation process
     * @return a map with an error message if validation fails, otherwise a success message
     * @throws SQLException if a database error occurs
     */
    @PostMapping(value = "/save-user")
    public Map<String, String> saveUser(@RequestBody @Valid UserDto user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    er -> errors.put(er.getField(), er.getDefaultMessage())
            );
            return errors;
        }
        Optional<UserDto> existingUser = userService.getUserByEmail(user.email());
        if (existingUser.isPresent()) {
            return Map.of("message", "User already exists with that email");
        } else {
            userService.addUser(user);
            return Map.of("message", "User added successfully");
        }
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the unique identifier of the user
     * @throws SQLException if a database error occurs
     */
    @DeleteMapping(value = "/delete-user/{id}")
    public void deleteUser(@Valid @PathVariable Long id) throws SQLException {
        userService.removeUser(id);
    }

    /**
     * Verifies if a user exists by their ID.
     *
     * @param id the unique identifier of the user
     * @return true if the user exists, otherwise false
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/verify-user/{id}")
    public Boolean verifyUser(@PathVariable @Valid Long id) throws SQLException {
        return userService.doesUserExist(id);
    }

    /**
     * Verifies if a user exists by their email.
     *
     * @param email the email of the user
     * @return true if the user exists, otherwise false
     * @throws SQLException if a database error occurs
     */
    @GetMapping(value = "/verify-user-by-email/{email}")
    public Boolean verifyUserByEmail(@PathVariable @Valid String email) throws SQLException {
        return userService.getUserByEmail(email).isPresent();
    }

    /**
     * Handles user login requests.
     *
     * @param loginRequest the login request data
     * @param bindingResult the result of the validation process
     * @return a ResponseEntity with a success message if the login is successful, otherwise a bad request message
     * @throws SQLException if a database error occurs
     */
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid Login loginRequest, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid login request");
        }
        Optional<UserDto> userDto = userService.getUserByEmail(loginRequest.email());
        if (userDto.isEmpty()) {
            return ResponseEntity.badRequest().body("Login failed");
        } else if (!Objects.equals(userDto.get().password(), loginRequest.password())){
            return ResponseEntity.badRequest().body("Invalid password");
        }
        return ResponseEntity.ok("Login successful");
    }
}