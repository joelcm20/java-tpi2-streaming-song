package com.informatorio.tpi2.dto.user;

import com.informatorio.tpi2.dto.playList.PlayListInfoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserInfoDto {
    private UUID id;
    private String name;
    private String username;
    private List<PlayListInfoDto> playLists = new ArrayList<>();
}
