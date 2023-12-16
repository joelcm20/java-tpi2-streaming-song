package com.informatorio.tpi2.service.artist;

import com.informatorio.tpi2.domain.Artist;
import com.informatorio.tpi2.repository.artist.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService implements IArtistService {
    private ArtistRepository artistRepository;

    @Override
    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }
}
