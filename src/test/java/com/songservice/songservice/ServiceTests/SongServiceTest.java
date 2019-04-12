package com.songservice.songservice.ServiceTests;


import com.songservice.songservice.models.Song;

import com.songservice.songservice.repositories.SongRepository;

import com.songservice.songservice.services.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Duration;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    private SongService songService;

    @Before
    public void setUp(){
        this.songService = new SongService(songRepository);
    }

    @Test
    public void saveSong_savesTheSong(){
        //arrange
        Song song = new Song("Africa","Toto", Duration.ofSeconds(274));

        //act
        songService.saveSong(song);

        //assert
        verify(songRepository, times(1)).save(song);
    }

    @Test
    public void getSongsByArtist_returnsSongsByThatArtist() {

        List<Song> song = songService.findSongsByArtist("Michael Jackson");
        //arrange

        //assert
        verify(songRepository, times(1)).findByArtist("Michael Jackson");
    }
}
