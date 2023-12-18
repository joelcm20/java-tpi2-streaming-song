package com.informatorio.tpi2.service.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User findById(UUID id);

    User findByUsername(String username) throws NotFoundException;

    List<User> findAll();
}
