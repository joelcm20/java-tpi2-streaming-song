package com.informatorio.tpi2.repository.artist;

import com.informatorio.tpi2.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    Artist findByName(String name);
}
