package com.informatorio.tpi2.bootstrap;

import com.informatorio.tpi2.domain.*;
import com.informatorio.tpi2.repository.artist.ArtistRepository;
import com.informatorio.tpi2.repository.genre.GenreRepository;
import com.informatorio.tpi2.repository.song.SongRepository;
import com.informatorio.tpi2.repository.user.UserRepository;
import com.informatorio.tpi2.service.artist.ArtistService;
import com.informatorio.tpi2.service.genre.GenreService;
import com.informatorio.tpi2.service.song.SongService;
import com.informatorio.tpi2.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private ArtistRepository artistRepository;
    private ArtistService artistService;
    private UserService userService;
    private UserRepository userRepository;
    private GenreService genreService;
    private GenreRepository genreRepository;
    private SongService songService;
    private SongRepository songRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
        loadArtists();
        loadGenres();
        loadSongs();
        loadPlayLists();
    }

    public void loadArtists() {
        Artist artist1 = new Artist();
        Artist artist2 = new Artist();
        artist1.setName("Alan");
        artist2.setName("Walker");
        artistRepository.saveAll(List.of(artist1, artist2));
    }

    public void loadUsers() {
        User user = new User();
        user.setName("joel");
        user.setUsername("joelcm20");
        user.setCreateAt(LocalDate.now());
        user.setCreatedBy("joel");
        user.setUpdatedAt(LocalDate.now());
        userRepository.save(user);
    }

    public void loadSongs() {
        Song faded = new Song();
        Song darkside = new Song();

        faded.setName("Faded");
        faded.setAlbum("popular");
        faded.setRanking(10);
        faded.setDuration(232);
        faded.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        faded.setArtists(List.of(artistService.findByName("Alan")));

        darkside.setName("darkside");
        darkside.setAlbum("popular");
        darkside.setRanking(9);
        darkside.setDuration(61);
        darkside.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        darkside.setArtists(List.of(artistService.findByName("Walker")));

        songRepository.saveAll(List.of(faded, darkside));
    }

    public void loadGenres() {
        Genre popGenre = new Genre();
        Genre electroGenre = new Genre();
        popGenre.setName("pop");
        electroGenre.setName("electro");
        genreRepository.saveAll(List.of(popGenre, electroGenre));
    }

    public void loadPlayLists() {
        User user1 = userService.findByUsername("joelcm20");
        PlayList playList = new PlayList();
        playList.setName("play list 1");
        playList.setLoop(Boolean.TRUE);
        playList.setRandom(Boolean.TRUE);
        playList.setIsPublic(Boolean.FALSE);
        playList.setCreateAt(LocalDate.now());
        playList.setUpdatedAt(LocalDate.now());
        playList.setCreatedBy("joelcm");
        playList.setUpdatedBy("joelcm");
        playList.setUser(user1);
        playList.setSongs(songService.findAll());
        user1.getPlayLists().add(playList);
        userRepository.save(user1);
    }
}
