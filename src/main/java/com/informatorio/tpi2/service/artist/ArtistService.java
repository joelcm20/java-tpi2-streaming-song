package com.informatorio.tpi2.service.artist;

import com.informatorio.tpi2.domain.Artist;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.repository.artist.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Artist> findByIds(List<UUID> ids) {
        List<Artist> artists = new ArrayList<>();
        for (UUID id : ids) {
            artists.add(artistRepository.findById(id).orElseThrow(() -> new NotFoundException("Artista", "id", id.toString())));
        }
        return artists;
    }

    @Override
    public Artist findById(UUID id) {
        return artistRepository.findById(id).orElseThrow(() -> new NotFoundException("Artist", "id", id.toString()));
    }
}
