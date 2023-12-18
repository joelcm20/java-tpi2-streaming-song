package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.dto.song.SongDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetSongsResponseDto {
    private String statusCode;
    private List<SongDto> songs;
}
