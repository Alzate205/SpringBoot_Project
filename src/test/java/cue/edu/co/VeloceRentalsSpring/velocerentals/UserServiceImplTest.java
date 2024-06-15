package cue.edu.co.VeloceRentalsSpring.velocerentals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.UserDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.User;
import cue.edu.co.VeloceRentalsSpring.velocerentals.repository.JPA.UserRepositoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepositoryJPA repository;

    @InjectMocks
    private cue.edu.co.VeloceRentalsSpring.velocerentals.services.implementations.UserServiceImpl service;

    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .name("John")
                .lastName("Doe")
                .username("johndoe")
                .password("password")
                .email("johndoe@example.com")
                .status(1)
                .build();

        userDto = UserDto.builder()
                .id(1L)
                .name("John")
                .lastName("Doe")
                .username("johndoe")
                .password("password")
                .email("johndoe@example.com")
                .status(1)
                .build();
    }

    @Test
    void testList() throws SQLException {
        when(repository.findAll()).thenReturn(List.of(user));

        List<UserDto> users = service.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("John", users.get(0).name());
    }

    @Test
    void testSearchById() throws SQLException {
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        UserDto result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals("John", result.name());
    }

    @Test
    void testSave() throws SQLException {
        service.addUser(userDto);

        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void testDelete() throws SQLException {
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        service.removeUser(1L);

        verify(repository, times(1)).delete(any(User.class));
    }

    @Test
    void testVerifyExist() throws SQLException {
        when(repository.existsById(1L)).thenReturn(true);

        Boolean exists = service.doesUserExist(1L);

        assertTrue(exists);
    }

    @Test
    void testSearchByEmail() throws SQLException {
        when(repository.findByEmail("johndoe@example.com")).thenReturn(user);

        Optional<UserDto> result = service.getUserByEmail("johndoe@example.com");

        assertTrue(result.isPresent());
        assertEquals("John", result.get().name());
    }
}
