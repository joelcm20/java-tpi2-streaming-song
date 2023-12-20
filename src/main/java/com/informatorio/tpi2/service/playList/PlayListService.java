package com.informatorio.tpi2.service.playList;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.repository.playList.PlayListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayListService implements IPlayListService {
    private PlayListRepository playListRepository;

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
}
