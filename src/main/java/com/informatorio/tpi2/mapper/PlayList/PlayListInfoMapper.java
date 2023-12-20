package com.informatorio.tpi2.mapper.PlayList;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.dto.playList.PlayListInfoDto;

import java.util.ArrayList;
import java.util.List;

public class PlayListInfoMapper {
    public static PlayListInfoDto mapToPlayListInfoDto(PlayList playList) {
        PlayListInfoDto playListInfoDto = new PlayListInfoDto();
        playListInfoDto.setId(playList.getId());
        playListInfoDto.setName(playList.getName());
        playListInfoDto.setNumberOfSongs(playList.getSongs().size());
        return playListInfoDto;
    }

    public static List<PlayListInfoDto> mapToPlayListInfoDto(List<PlayList> playLists) {
        List<PlayListInfoDto> playListInfoDtos = new ArrayList<>();
        for (PlayList pl : playLists) {
            playListInfoDtos.add(mapToPlayListInfoDto(pl));
        }
        return playListInfoDtos;
    }
}
