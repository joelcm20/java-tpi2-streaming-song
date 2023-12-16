package com.informatorio.tpi2.service.genre;

import com.informatorio.tpi2.domain.Genre;

public interface IGenreService {
    Genre findByName(String name);
}
