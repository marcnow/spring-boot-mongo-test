package de.adesso.hellospring.service.impl;

import de.adesso.hellospring.model.User;
import de.adesso.hellospring.model.dto.UserDto;
import de.adesso.hellospring.repository.UserRepository;
import de.adesso.hellospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return user;
    }

    @Override
    public UserDto createUser(String firstName, String lastName, String address) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .build();

        userRepository.save(user);

        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .build();

        return userDto;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
