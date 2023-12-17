package com.informatorio.tpi2.controller.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.mapper.user.UserMapper;
import com.informatorio.tpi2.repository.user.UserRepository;
import com.informatorio.tpi2.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private UserRepository userRepository;

    @GetMapping
    public List<UserDto> getUsers() {
        return UserMapper.mapToUserDto(userService.findAll());
    }

    @GetMapping("{username}")
    public UserDto getUsername(@PathVariable(name = "username") String username) {
        return UserMapper.mapToUserDto(userService.findByUsername(username));
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userBody) {
        User newUser = UserMapper.mapToUser(userBody);
        userRepository.save(newUser);
        return "user created";
    }
}
