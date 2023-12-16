package com.informatorio.tpi2.service.artist;

import com.informatorio.tpi2.domain.Artist;

import java.util.List;

public interface IArtistService {
    Artist findByName(String name);

    List<Artist> findAll();
}
