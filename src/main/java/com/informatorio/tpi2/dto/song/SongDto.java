package com.informatorio.tpi2.dto.song;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class SongDto {
    private UUID id;
    private String name;
    private int ranking;
    private List<UUID> genres = new ArrayList<>();
    private int duration;
    private List<UUID> artists = new ArrayList<>();
    private String album;
}
