package com.informatorio.tpi2.dto.playList;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PlayListDto {
    private String name;
    private UUID user;
    private List<UUID> songs = new ArrayList<>();
    private Boolean loop;
    private Boolean random;
    private Boolean isPublic;
}
