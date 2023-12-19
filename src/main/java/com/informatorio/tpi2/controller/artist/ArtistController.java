package com.informatorio.tpi2.controller.artist;


import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.domain.Artist;
import com.informatorio.tpi2.dto.responses.get.GetArtistResponseDto;
import com.informatorio.tpi2.service.artist.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/artist")
public class ArtistController {
    private ArtistService artistService;

    @GetMapping("{id}")
    public ResponseEntity<GetArtistResponseDto> getArtist(@PathVariable(name = "id") UUID id) {
        Artist artist = artistService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new GetArtistResponseDto(ConstantUtils.STATUS_200, artist));
    }
}
