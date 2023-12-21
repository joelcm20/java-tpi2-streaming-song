package com.informatorio.tpi2.dto.responses.post;

import com.informatorio.tpi2.dto.playList.PlayListInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddSongToPlayListResponseDto {
    private String statusCode;
    private PlayListInfoDto playList;
}
