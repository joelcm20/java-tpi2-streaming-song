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
        Artist artist3 = new Artist();
        artist1.setName("Alan");
        artist2.setName("Walker");
        artist3.setName("Imagine Dragons");
        artistRepository.saveAll(List.of(artist1, artist2, artist3));
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
        Song demons = new Song();
        Song happier = new Song();

        faded.setName("Faded");
        faded.setAlbum("Different World");
        faded.setRanking(10);
        faded.setDuration(232);
        faded.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        faded.setArtists(List.of(artistService.findByName("Alan")));

        darkside.setName("darkside");
        darkside.setAlbum("Walkerworld");
        darkside.setRanking(9);
        darkside.setDuration(61);
        darkside.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        darkside.setArtists(List.of(artistService.findByName("Walker")));

        darkside.setName("darkside");
        darkside.setAlbum("popular");
        darkside.setRanking(9);
        darkside.setDuration(61);
        darkside.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        darkside.setArtists(List.of(artistService.findByName("Walker")));

        demons.setName("demons");
        demons.setAlbum("Night Visions");
        demons.setRanking(25);
        demons.setDuration(177);
        demons.setGenres(List.of(genreService.findByName("pop"), genreService.findByName("electro")));
        demons.setArtists(List.of(artistService.findByName("Imagine Dragons")));

        happier.setName("happier");
        happier.setAlbum("Happier");
        happier.setRanking(13);
        happier.setDuration(214);
        happier.setGenres(List.of(genreService.findByName("dance pop"), genreService.findByName("R&B/Soul")));
        happier.setArtists(List.of(artistService.findByName("Imagine Dragons")));

        songRepository.saveAll(List.of(faded, darkside, demons));
    }

    public void loadGenres() {
        Genre pop = new Genre();
        Genre electro = new Genre();
        Genre rockAlternativo = new Genre();
        Genre popRock = new Genre();
        Genre electroPop = new Genre();
        Genre dancePop = new Genre();
        Genre RyB_Soul = new Genre();
        pop.setName("pop");
        electro.setName("electro");
        rockAlternativo.setName("rock alternativo");
        popRock.setName("pop rock");
        electroPop.setName("electro pop");
        dancePop.setName("dance pop");
        RyB_Soul.setName("RyB_Soul");
        genreRepository.saveAll(List.of(pop, electro, rockAlternativo, popRock, electroPop, dancePop, RyB_Soul));
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
