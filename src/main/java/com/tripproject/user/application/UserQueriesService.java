package com.tripproject.user.application;

import com.tripproject.user.application.port.in.UserQueriesUseCase;
import com.tripproject.user.application.port.out.UserRepositoryPort;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@Transactional
@Service
public class UserQueriesService implements UserQueriesUseCase {

        private final UserRepositoryPort userRepositoryPort;




    public User findId(Long id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(NotFoundUserExcepton::new);
    }
}
