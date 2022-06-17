package com.tripproject.user.application;

import com.tripproject.user.application.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@Transactional
@Service
public class UserService {

    //private final UserRepositoryPort userRepositoryPort;
}
