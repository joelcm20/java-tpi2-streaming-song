package com.informatorio.tpi2.service.song;

import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.repository.song.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SongService implements ISongService {
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findByName(String name) {
        return songRepository.findByName(name);
    }

    @Override
    public List<Song> findByIds(List<UUID> ids) {
        List<Song> songs = new ArrayList<>();
        for (UUID id : ids) {
            songs.add(songRepository.findById(id).orElseThrow(() -> new NotFoundException("Song", "id", id.toString())));
        }
        return songs;
    }

    @Override
    public List<Song> findByFilterQuery(String name, String genre, String artist, String album) {
        return songRepository.findByFilterQuery(name, genre, artist, album);
    }
}
