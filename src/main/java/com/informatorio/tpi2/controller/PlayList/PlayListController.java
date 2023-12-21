package com.informatorio.tpi2.controller.PlayList;

import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import com.informatorio.tpi2.dto.playList.PlayListInfoDto;
import com.informatorio.tpi2.dto.request.AddSongToPlayListRequestDto;
import com.informatorio.tpi2.dto.responses.get.GetPlayListsResponseDto;
import com.informatorio.tpi2.dto.responses.get.GetSongsResponseDto;
import com.informatorio.tpi2.dto.responses.get.GetUserPlayListsResponseDto;
import com.informatorio.tpi2.dto.responses.post.AddSongToPlayListResponseDto;
import com.informatorio.tpi2.dto.responses.post.CreatePlayListResponseDto;
import com.informatorio.tpi2.dto.song.SongDto;
import com.informatorio.tpi2.exception.UserRequiredException;
import com.informatorio.tpi2.mapper.PlayList.PlayListInfoMapper;
import com.informatorio.tpi2.mapper.PlayList.PlayListMapper;
import com.informatorio.tpi2.mapper.song.SongMapper;
import com.informatorio.tpi2.service.playList.PlayListService;
import com.informatorio.tpi2.service.song.ISongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/playlist")
public class PlayListController {
    private PlayListService playListService;

    @GetMapping
    public ResponseEntity<GetPlayListsResponseDto> getPublicPlayListsByName(@RequestParam(name = "name", required = false) String name) {
        List<PlayListDto> playListDtos;
        if (!Objects.isNull(name)) {
            List<PlayList> playLists = playListService.getPublicPlayListsByName("%" + name + "%");
            playListDtos = PlayListMapper.mapToPlayListDto(playLists);
            return ResponseEntity.status(HttpStatus.OK).body(new GetPlayListsResponseDto(ConstantUtils.STATUS_200, playListDtos));
        }
        playListDtos = PlayListMapper.mapToPlayListDto(playListService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(new GetPlayListsResponseDto(ConstantUtils.STATUS_200, playListDtos));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<GetUserPlayListsResponseDto> getUserPlayListsByIdOrderByCreatedAt(@PathVariable(name = "id") UUID id) {
        List<PlayList> platLists = playListService.findUserPlayListsByIdOrderByCreated(id);
        List<PlayListDto> playListDtos = PlayListMapper.mapToPlayListDto(platLists);
        return ResponseEntity.status(HttpStatus.OK).body(new GetUserPlayListsResponseDto(ConstantUtils.STATUS_200, playListDtos));
    }

    @GetMapping("/songs/{idPlaylist}")
    public ResponseEntity<GetSongsResponseDto> getSongsPlayListById(@PathVariable(name = "idPlaylist") UUID id) {
        List<Song> songs = playListService.findSongsPlayListById(id);
        List<SongDto> songDtos = SongMapper.mapToSongDto(songs);
        return ResponseEntity.status(HttpStatus.OK).body(new GetSongsResponseDto(ConstantUtils.STATUS_200, songDtos));
    }

    @PostMapping
    public ResponseEntity<CreatePlayListResponseDto> createPlayList(@RequestBody PlayListDto body) throws UserRequiredException {
        PlayList playList = playListService.createPlayLists(body);
        PlayListDto playListDto = PlayListMapper.mapToPlayListDto(playList);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatePlayListResponseDto(ConstantUtils.STATUS_201, playListDto));
    }

    @PostMapping("/{idPlayList}/add/{idSong}")
    public ResponseEntity<AddSongToPlayListResponseDto> addSongToPlayList(@RequestBody AddSongToPlayListRequestDto body, @PathVariable("idPlayList") UUID idPlayList, @PathVariable("idSong") UUID idSong) {
        PlayList playList = playListService.addSongToPlayList(body, idPlayList, idSong);
        PlayListInfoDto playListInfoDto = PlayListInfoMapper.mapToPlayListInfoDto(playList);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AddSongToPlayListResponseDto(ConstantUtils.STATUS_201, playListInfoDto));
    }
}
