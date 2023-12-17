package com.informatorio.tpi2.service.playList;

import com.informatorio.tpi2.domain.PlayList;

import java.util.List;
import java.util.UUID;

public interface IPlayListService {
    List<PlayList> findByIds(List<UUID> ids);

    PlayList findById(UUID id);
}