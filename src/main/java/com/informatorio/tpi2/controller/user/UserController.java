package com.informatorio.tpi2.controller.user;

import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.responses.get.GetUserResponseDto;
import com.informatorio.tpi2.dto.responses.get.GetUsersResponseDto;
import com.informatorio.tpi2.dto.responses.post.CreateUserResponseDto;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.mapper.user.UserMapper;
import com.informatorio.tpi2.repository.user.UserRepository;
import com.informatorio.tpi2.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<GetUsersResponseDto> getUsers() {
        List<UserDto> users = UserMapper.mapToUserDto(userService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(new GetUsersResponseDto(ConstantUtils.STATUS_200, users));
    }


    @GetMapping("{username}")
    public ResponseEntity<GetUserResponseDto> getUserByUsername(@PathVariable(name = "username") String username) {
        UserDto user = UserMapper.mapToUserDto(userService.findByUsername(username));
        return ResponseEntity.status(HttpStatus.OK).body(new GetUserResponseDto(ConstantUtils.STATUS_200, user));
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody UserDto userBody) {
        User user = userService.createUser(userBody);
        UserDto userDto = UserMapper.mapToUserDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateUserResponseDto(ConstantUtils.STATUS_201, userDto));
    }
}
