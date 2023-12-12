package com.informatorio.tpi2.domain;

import java.util.List;
import java.util.UUID;

public class Song {
    private UUID id;
    private String name;
    private int ranking;
    List<Genre> genres;
    private double duration;
    private Artist artist;
    private String album;
}
