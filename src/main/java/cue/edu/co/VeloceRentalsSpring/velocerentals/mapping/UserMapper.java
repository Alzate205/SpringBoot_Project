package cue.edu.co.VeloceRentalsSpring.velocerentals.mapping;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.UserDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.User;

/**
 * This class is responsible for mapping between UserDto and User model objects.
 * It provides methods to convert between these two representations.
 */
public class UserMapper {

    /**
     * Maps a UserDto object to a User model object.
     *
     * @param userDto the UserDto object to be mapped
     * @return the mapped User model object
     */
    public static User mapFromDTO(UserDto userDto) {
        return User.builder()
                .id(userDto.id())
                .name(userDto.name())
                .lastName(userDto.lastName())
                .username(userDto.username())
                .password(userDto.password())
                .email(userDto.email())
                .status(userDto.status())
                .build();
    }

    /**
     * Maps a User model object to a UserDto object.
     *
     * @param user the User model object to be mapped
     * @return the mapped UserDto object
     */
    public static UserDto mapFromModel(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}
