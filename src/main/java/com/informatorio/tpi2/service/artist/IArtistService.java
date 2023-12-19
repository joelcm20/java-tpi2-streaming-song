package com.informatorio.tpi2.service.artist;

import com.informatorio.tpi2.domain.Artist;

import java.util.List;
import java.util.UUID;

public interface IArtistService {
    Artist findByName(String name);

    List<Artist> findAll();

    List<Artist> findByIds(List<UUID> ids);

    Artist findById(UUID id);
}
