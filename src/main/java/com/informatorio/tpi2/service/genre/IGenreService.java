package com.informatorio.tpi2.service.genre;

import com.informatorio.tpi2.domain.Genre;

import java.util.List;
import java.util.UUID;

public interface IGenreService {
    Genre findByName(String name);

    List<Genre> findByIds(List<UUID> ids);
}
