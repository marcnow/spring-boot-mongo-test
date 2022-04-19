package de.adesso.hellospring.service;

import de.adesso.hellospring.model.User;
import de.adesso.hellospring.model.dto.UserDto;

public interface UserService {
    User getUser(String userId);

    UserDto createUser(String firstName, String lastName, String address);

    void deleteUser(String userId);
}
