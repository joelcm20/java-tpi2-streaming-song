package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponseDto {
    private String statusCode;
    private UserDto user;
}
