package com.informatorio.tpi2.dto.responses.post;

import com.informatorio.tpi2.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResponseDto {
    private String StatusCode;
    private UserDto userDto;
}
