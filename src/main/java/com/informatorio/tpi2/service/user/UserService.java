package com.informatorio.tpi2.service.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario", "id", id.toString()));
    }

    @Override
    public User findByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new NotFoundException("Usuario", "username", username);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
