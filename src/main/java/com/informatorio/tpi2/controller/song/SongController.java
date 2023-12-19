package com.informatorio.tpi2.controller.song;

import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.dto.responses.get.GetSongsResponseDto;
import com.informatorio.tpi2.dto.song.SongDto;
import com.informatorio.tpi2.mapper.song.SongMapper;
import com.informatorio.tpi2.service.song.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/song")
public class SongController {
    private SongService songService;

    @GetMapping
    public ResponseEntity<GetSongsResponseDto> getSongs(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "genre", required = false) String genre,
            @RequestParam(name = "artist", required = false) String artist,
            @RequestParam(name = "album", required = false) String album
    ) {
        List<SongDto> songs;
        if (Objects.isNull(name) && Objects.isNull(genre) && Objects.isNull(album) && !Objects.isNull(artist)) {
            songs = SongMapper.mapToSongDto(songService.findByArtistOrderByRankingAscQuery(artist));
            return ResponseEntity.status(HttpStatus.OK).body(new GetSongsResponseDto(ConstantUtils.STATUS_200, songs));
        }
        songs = SongMapper.mapToSongDto(songService.findByFilterQuery(name, genre, artist, album));
        return ResponseEntity.status(HttpStatus.OK).body(new GetSongsResponseDto(ConstantUtils.STATUS_200, songs));
    }
}
