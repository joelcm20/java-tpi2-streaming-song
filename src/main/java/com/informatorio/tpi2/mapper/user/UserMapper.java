package com.informatorio.tpi2.mapper.user;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import com.informatorio.tpi2.service.playList.PlayListService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserMapper {
    private static PlayListService playListService;

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        for (PlayList pl : user.getPlayLists()) {
            userDto.getPlayLists().add(pl.getId());
        }
        return userDto;
    }

    public static List<UserDto> mapToUserDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(mapToUserDto(user));
        }
        return userDtos;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        if (!userDto.getPlayLists().isEmpty()) {
            user.setPlayLists(playListService.findByIds(userDto.getPlayLists()));
        }
        return user;
    }
}
