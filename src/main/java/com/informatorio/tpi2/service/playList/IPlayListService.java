package com.informatorio.tpi2.service.playList;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import com.informatorio.tpi2.dto.request.AddSongToPlayListRequestDto;
import com.informatorio.tpi2.dto.request.DeleteSongFromPlayListRequestDto;
import com.informatorio.tpi2.dto.responses.post.AddSongToPlayListResponseDto;
import com.informatorio.tpi2.exception.UserRequiredException;

import java.util.List;
import java.util.UUID;

public interface IPlayListService {
    List<PlayList> findByIds(List<UUID> ids);

    PlayList findById(UUID id);

    List<PlayList> getPublicPlayListsByName(String name);

    List<PlayList> findAll();

    List<PlayList> findUserPlayListsByIdOrderByCreated(UUID id);

    List<Song> findSongsPlayListById(UUID id);

    PlayList createPlayLists(PlayListDto playListDto) throws UserRequiredException;

    PlayList addSongToPlayList(AddSongToPlayListRequestDto body, UUID idPlayList, UUID idSong);

    void deleteSongFromPlayList(DeleteSongFromPlayListRequestDto body, UUID idPlayList, UUID idSong);
}
