package com.informatorio.tpi2.service.song;

import com.informatorio.tpi2.domain.Song;

import java.util.List;
import java.util.UUID;

public interface ISongService {
    List<Song> findAll();

    Song findByName(String name);

    List<Song> findByIds(List<UUID> ids);

    List<Song> findByFilterQuery(String name, String genre, String artist, String album);

    List<Song> findByArtistOrderByRankingAscQuery(String artist);
}
