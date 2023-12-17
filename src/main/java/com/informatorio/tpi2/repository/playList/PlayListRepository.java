package com.informatorio.tpi2.repository.playList;

import com.informatorio.tpi2.domain.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayListRepository extends JpaRepository<PlayList, UUID> {
}
