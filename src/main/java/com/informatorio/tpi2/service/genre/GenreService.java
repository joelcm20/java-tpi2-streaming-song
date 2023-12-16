package com.informatorio.tpi2.service.genre;

import com.informatorio.tpi2.domain.Genre;
import com.informatorio.tpi2.repository.genre.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreService implements IGenreService {
    private GenreRepository genreRepository;

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
}
