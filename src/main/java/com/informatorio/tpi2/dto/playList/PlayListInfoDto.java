package com.informatorio.tpi2.dto.playList;

import lombok.Data;

import java.util.UUID;

@Data
public class PlayListInfoDto {
    private UUID id;
    private String name;
    private int numberOfSongs;
}
