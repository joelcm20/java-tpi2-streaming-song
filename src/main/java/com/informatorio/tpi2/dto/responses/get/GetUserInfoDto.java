package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.dto.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserInfoDto {
    private String statusCode;
    private UserInfoDto user;
}
