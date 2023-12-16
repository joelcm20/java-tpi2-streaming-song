package com.informatorio.tpi2.repository.genre;

import com.informatorio.tpi2.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
    Genre findByName(String name);
}
