package com.informatorio.tpi2.service.user;

import com.informatorio.tpi2.domain.User;

public interface IUserService {
    User findByUsername(String username);
}
