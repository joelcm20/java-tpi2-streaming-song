package com.informatorio.tpi2.mapper.PlayList;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import com.informatorio.tpi2.service.song.SongService;
import com.informatorio.tpi2.service.user.UserService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayListMapper {
    private static UserService userService;
    private static SongService songService;

    public static PlayListDto mapToPlayListDto(PlayList playList) {
        PlayListDto playListDto = new PlayListDto();
        playListDto.setId(playList.getId());
        playListDto.setName(playList.getName());
        playListDto.setLoop(playList.getLoop());
        playListDto.setRandom(playList.getRandom());
        playListDto.setIsPublic(playList.getIsPublic());
        playListDto.setUser(playList.getUser().getId());
        for (Song song : playList.getSongs()) {
            playListDto.getSongs().add(song.getId());
        }
        return playListDto;
    }

    public static List<PlayListDto> mapToPlayListDto(List<PlayList> playLists) {
        List<PlayListDto> playListDtos = new ArrayList<>();
        for (PlayList pl : playLists) {
            playListDtos.add(mapToPlayListDto(pl));
        }
        return playListDtos;
    }

    public static PlayList mapToPlayList(PlayListDto playListDto) {
        PlayList playList = new PlayList();
        playList.setName(playListDto.getName());
        playList.setLoop(playListDto.getLoop());
        playList.setRandom(playListDto.getRandom());
        playList.setIsPublic(playListDto.getIsPublic());
        playList.setUser(userService.findById(playListDto.getUser()));
        playList.setSongs(songService.findByIds(playListDto.getSongs()));
        return playList;
    }
}
