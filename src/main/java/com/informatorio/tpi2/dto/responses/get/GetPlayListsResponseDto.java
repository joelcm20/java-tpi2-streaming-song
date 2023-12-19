package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.dto.playList.PlayListDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetPlayListsResponseDto {
    private String statusCode;
    private List<PlayListDto> playLists;
}
