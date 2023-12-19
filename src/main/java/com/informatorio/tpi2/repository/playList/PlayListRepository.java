package com.informatorio.tpi2.repository.playList;

import com.informatorio.tpi2.domain.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayListRepository extends JpaRepository<PlayList, UUID> {
    @Query("SELECT p FROM PlayList p WHERE p.isPublic=TRUE AND UPPER(p.name) LIKE UPPER(:name)")
    List<PlayList> getPublicPlayListsByNameQuery(@Param("name") String name);
}
