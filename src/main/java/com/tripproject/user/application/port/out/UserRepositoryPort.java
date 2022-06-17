package com.tripproject.user.application.port.out;

import com.tripproject.user.domain.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Long save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUserId(String userId);
    Optional<User> findByEmail(String string);

}
