package com.informatorio.tpi2.dto.responses.post;

import com.informatorio.tpi2.domain.PlayList;
import com.informatorio.tpi2.dto.playList.PlayListDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePlayListResponseDto {
    private String statusCode;
    private PlayListDto playList;
}
