package com.informatorio.tpi2.dto.user;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private String username;
    private List<UUID> playLists = new ArrayList<>();
}