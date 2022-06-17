package com.tripproject.user.application.port.in;

import com.tripproject.user.domain.User;

public interface UserQueriesUseCase {


    public User findId(Long id);

}
