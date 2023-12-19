package com.informatorio.tpi2.controller.PlayList;

import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import com.informatorio.tpi2.dto.responses.get.GetPlayListsResponseDto;
import com.informatorio.tpi2.mapper.PlayList.PlayListMapper;
import com.informatorio.tpi2.service.playList.PlayListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/playlist")
public class PlayListController {
    private PlayListService playListService;

    @GetMapping
    public ResponseEntity<GetPlayListsResponseDto> getPublicPlayListsByName(@RequestParam(name = "name", required = false) String name) {
        List<PlayListDto> playListDtos;
        if (!Objects.isNull(name)) {
            List<PlayList> playLists = playListService.getPublicPlayListsByName("%" + name + "%");
            playListDtos = PlayListMapper.mapToPlayListDto(playLists);
            return ResponseEntity.status(HttpStatus.OK).body(new GetPlayListsResponseDto(ConstantUtils.STATUS_200, playListDtos));
        }
        playListDtos = PlayListMapper.mapToPlayListDto(playListService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(new GetPlayListsResponseDto(ConstantUtils.STATUS_200, playListDtos));
    }
}
