package com.tripproject.user.adapter.out;

import com.tripproject.user.application.port.out.UserRepositoryPort;
import com.tripproject.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor

public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Override
    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public Optional<User> findByEmail(String string) {
        return userRepository.findByEmail(string);
    }
}

