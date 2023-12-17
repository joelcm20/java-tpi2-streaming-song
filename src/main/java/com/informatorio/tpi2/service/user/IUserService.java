package com.informatorio.tpi2.service.user;

import com.informatorio.tpi2.domain.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User findById(UUID id);

    User findByUsername(String username);

    List<User> findAll();
}
