package com.informatorio.tpi2.service.playList;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.domain.User;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import com.informatorio.tpi2.dto.request.AddSongToPlayListRequestDto;
import com.informatorio.tpi2.dto.request.DeleteSongFromPlayListRequestDto;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.exception.UnauthorizedException;
import com.informatorio.tpi2.exception.UserRequiredException;
import com.informatorio.tpi2.mapper.PlayList.PlayListMapper;
import com.informatorio.tpi2.repository.playList.PlayListRepository;
import com.informatorio.tpi2.repository.user.UserRepository;
import com.informatorio.tpi2.service.song.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayListService implements IPlayListService {
    private PlayListRepository playListRepository;
    private UserRepository userRepository;
    private SongService songService;

    @Override
    public List<PlayList> findByIds(List<UUID> ids) {
        List<PlayList> playLists = new ArrayList<>();
        for (UUID id : ids) {
            playLists.add(playListRepository.findById(id).orElseThrow(() -> new RuntimeException("play list not found")));
        }
        return playLists;
    }

    @Override
    public PlayList findById(UUID id) {
        return playListRepository.findById(id).orElseThrow(() -> new RuntimeException("PlayList not found"));
    }

    @Override
    public List<PlayList> getPublicPlayListsByName(String name) {
        return playListRepository.getPublicPlayListsByNameQuery(name);
    }

    @Override
    public List<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public List<PlayList> findUserPlayListsByIdOrderByCreated(UUID id) {
        return playListRepository.getUserPlayListsByIdOrderByCreated(id);
    }

    @Override
    public List<Song> findSongsPlayListById(UUID id) {
        return playListRepository.getSongsPlayListById(id);
    }

    @Override
    public PlayList createPlayLists(PlayListDto playListDto) throws UserRequiredException {
        User user = validateUserId(playListDto.getUser());
        PlayList newPlayList = PlayListMapper.mapToPlayList(playListDto);
        newPlayList.setUser(user);
        newPlayList.setSongs(songService.findByIds(playListDto.getSongs()));
        return playListRepository.save(newPlayList);
    }

    private User validateUserId(UUID id) throws UserRequiredException {
        if (Objects.isNull(id)) {
            throw new UserRequiredException();
        }
        return userRepository.findById(id).orElseThrow(() -> new UserRequiredException(id));
    }

    @Override
    public PlayList addSongToPlayList(AddSongToPlayListRequestDto body, UUID idPlayList, UUID idSong) {
        PlayList playList = playListRepository.findById(idPlayList).orElseThrow(() -> new NotFoundException("Playlist", "id", idPlayList.toString()));
        if (!isOwnerOf(playList, body.getUserId())) {
            throw new UnauthorizedException();
        }
        Song song = songService.findById(idSong);
        playList.getSongs().add(song);
        return playListRepository.save(playList);
    }

    private Boolean isOwnerOf(PlayList playList, UUID userId) {
        return playList.getUser().getId().equals(userId);
    }

    @Override
    public void deleteSongFromPlayList(DeleteSongFromPlayListRequestDto body, UUID idPlayList, UUID idSong) {
        PlayList playList = playListRepository.findById(idPlayList).orElseThrow(() -> new NotFoundException("Playlist", "id", idPlayList.toString()));
        if (!isOwnerOf(playList, body.getUserId())) {
            throw new UnauthorizedException();
        }
        playList.getSongs().removeIf((s) -> s.getId().equals(idSong));
        playListRepository.save(playList);
    }
}
