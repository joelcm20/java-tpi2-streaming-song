package com.informatorio.tpi2.service.song;

import com.informatorio.tpi2.domain.Song;
import com.informatorio.tpi2.repository.song.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
