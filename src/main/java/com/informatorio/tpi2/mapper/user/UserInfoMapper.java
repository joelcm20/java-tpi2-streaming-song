package com.informatorio.tpi2.mapper.user;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserInfoDto;

import java.util.ArrayList;
import java.util.List;

public class UserInfoMapper {
    public static UserInfoDto mapToUserInfoDto(User user) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(user.getId());
        userInfoDto.setName(user.getName());
        userInfoDto.setUsername(user.getUsername());
        return userInfoDto;
    }

    public static List<UserInfoDto> mapToUserInfoDto(List<User> users) {
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        for (User user : users) {
            userInfoDtos.add(mapToUserInfoDto(user));
        }
        return userInfoDtos;
    }
}
