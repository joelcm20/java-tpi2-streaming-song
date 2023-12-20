package com.informatorio.tpi2.service.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.exception.UserAlreadyExistsException;
import com.informatorio.tpi2.mapper.user.UserMapper;
import com.informatorio.tpi2.repository.user.UserRepository;
import com.informatorio.tpi2.service.playList.PlayListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserRepository userRepository;
    private PlayListService playListService;

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

    @Override
    public User createUser(UserDto userDto) throws UserAlreadyExistsException {
        if (this.usernameAlreadyExists(userDto.getUsername())) {
            throw new UserAlreadyExistsException(userDto.getUsername());
        }
        User newUser = UserMapper.mapToUser(userDto);
        if (!userDto.getPlayLists().isEmpty()) {
            newUser.setPlayLists(playListService.findByIds(userDto.getPlayLists()));
        }
        return userRepository.save(newUser);
    }

    private Boolean usernameAlreadyExists(String username) {
        User user = userRepository.findByUsername(username);
        return !Objects.isNull(user);
    }
}
