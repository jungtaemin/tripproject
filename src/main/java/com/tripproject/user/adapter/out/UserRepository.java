package com.tripproject.user.adapter.out;

import com.tripproject.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // id로 User찾기
    Optional<User> findByUserId(String ProviderId);


    Optional<User> findByEmail(String string);
}
