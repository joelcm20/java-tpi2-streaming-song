package com.informatorio.tpi2.repository.song;

import com.informatorio.tpi2.domain.Artist;
import com.informatorio.tpi2.domain.Genre;
import com.informatorio.tpi2.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SongRepository extends JpaRepository<Song, UUID> {
    Song findByName(String name);

    @Query("SELECT s FROM Song s INNER JOIN s.genres g INNER JOIN s.artists a WHERE " +
            "(:name IS NULL OR UPPER(s.name)=UPPER(:name)) AND " +
            "(:genre IS NULL OR UPPER(g.name)=UPPER(:genre)) AND " +
            "(:artist IS NULL OR UPPER(a.name)=UPPER(:artist)) AND " +
            "(:album IS NULL OR UPPER(s.album)=UPPER(:album))")
    List<Song> findByFilterQuery(
            @Param("name") String name,
            @Param("genre") String genre,
            @Param("artist") String artist,
            @Param("album") String album
    );

    @Query("SELECT s FROM Song s INNER JOIN s.artists a WHERE UPPER(a.name)=UPPER(:artist) ORDER BY s.ranking ASC")
    List<Song> findByArtistOrderByRankingAscQuery(@Param("artist") String artist);
}
