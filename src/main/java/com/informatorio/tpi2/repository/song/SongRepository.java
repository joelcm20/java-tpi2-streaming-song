package com.informatorio.tpi2.repository.song;

import com.informatorio.tpi2.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SongRepository extends JpaRepository<Song, UUID> {
    Song findByName(String name);
}