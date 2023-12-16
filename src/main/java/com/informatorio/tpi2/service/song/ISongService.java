package com.informatorio.tpi2.service.song;

import com.informatorio.tpi2.domain.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findByName(String name);
}
