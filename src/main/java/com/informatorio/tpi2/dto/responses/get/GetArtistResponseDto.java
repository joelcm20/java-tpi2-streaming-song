package com.informatorio.tpi2.dto.responses.get;

import com.informatorio.tpi2.domain.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetArtistResponseDto {
    private String statusCode;
    private Artist artist;
}
