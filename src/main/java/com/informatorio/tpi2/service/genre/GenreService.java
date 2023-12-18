package com.informatorio.tpi2.service.genre;

import com.informatorio.tpi2.domain.Genre;
import com.informatorio.tpi2.exception.NotFoundException;
import com.informatorio.tpi2.repository.genre.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GenreService implements IGenreService {
    private GenreRepository genreRepository;

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public List<Genre> findByIds(List<UUID> ids) {
        List<Genre> genres = new ArrayList<>();
        for (UUID id : ids) {
            genres.add(genreRepository.findById(id).orElseThrow(() -> new NotFoundException("Genero", "id", id.toString())));
        }
        return genres;
    }
}
