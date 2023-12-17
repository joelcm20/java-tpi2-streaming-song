package com.informatorio.tpi2.controller.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.mapper.user.UserMapper;
import com.informatorio.tpi2.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return UserMapper.mapToUserDto(userService.findAll());
    }

    @GetMapping("{username}")
    public UserDto getUsername(@PathVariable(name = "username") String username) {
        return UserMapper.mapToUserDto(userService.findByUsername(username));
    }
}
