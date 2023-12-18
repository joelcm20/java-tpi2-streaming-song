package com.informatorio.tpi2.mapper.song;

import com.informatorio.tpi2.domain.Artist;
import com.informatorio.tpi2.domain.Genre;
import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.dto.song.SongDto;
import com.informatorio.tpi2.service.artist.ArtistService;
import com.informatorio.tpi2.service.genre.GenreService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SongMapper {
    private static GenreService genreService;
    private static ArtistService artistService;

    public static SongDto mapToSongDto(Song song) {
        SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setName(song.getName());
        songDto.setAlbum(song.getAlbum());
        songDto.setDuration(song.getDuration());
        songDto.setRanking(song.getRanking());
        for (Genre genre : song.getGenres()) {
            songDto.getGenres().add(genre.getId());
        }
        for (Artist artist : song.getArtists()) {
            songDto.getArtists().add(artist.getId());
        }
        return songDto;
    }

    public static List<SongDto> mapToSongDto(List<Song> songs) {
        List<SongDto> songDtos = new ArrayList<>();
        for (Song song : songs) {
            songDtos.add(mapToSongDto(song));
        }
        return songDtos;
    }

    public static Song mapToSong(SongDto songDto) {
        Song song = new Song();
        song.setId(songDto.getId());
        song.setName(songDto.getName());
        song.setAlbum(songDto.getAlbum());
        song.setDuration(songDto.getDuration());
        song.setRanking(songDto.getRanking());
        if (!songDto.getGenres().isEmpty()) {
            song.setGenres(genreService.findByIds(songDto.getGenres()));
        }
        if (!songDto.getArtists().isEmpty()) {
            song.setArtists(artistService.findByIds(songDto.getArtists()));
        }
        return song;
    }
}
