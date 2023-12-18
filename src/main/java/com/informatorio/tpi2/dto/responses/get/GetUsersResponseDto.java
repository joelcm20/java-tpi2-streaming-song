package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetUsersResponseDto {
    private String statusCode;
    private List<UserDto> users;
}
