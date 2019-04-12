package com.songservice.songservice.RepositoryTests;

import com.songservice.songservice.models.Song;
import com.songservice.songservice.repositories.SongRepository;
import com.songservice.songservice.TestUtils.TestSongs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

@DataMongoTest
public class SongRepositoryTest {

    private List<Song> testSongs;
    @Before
    public void setUp(){
        testSongs = new ArrayList<>();
        for (Song song: TestSongs.getSongs()){
            Song songWithId = songRepository.save(song);
            testSongs.add(songWithId);

        }

    }

    @After

    public  void tearDown(){
        for(Song song:testSongs){
            songRepository.delete(song);
        }
    }


    @Autowired
    private SongRepository songRepository;

    @Test
    public void repoSavesInDB() throws Exception {
        Song song = TestSongs.getSongs().get(0);

       Song songSaved = songRepository.save(song);
        Song foundSong = songRepository.findById(songSaved.getId()).orElse(null);
        assertThat(foundSong.getTitle()).isEqualTo(song.getTitle());
    }

    @Test
    public void repoSearchesByartist() throws Exception{
        List<Song> songByArtist = songRepository.findByArtist("Michael Jackson");

        for(Song song: songByArtist){
            assertThat(song.getArtist()).isEqualTo("Michael Jackson");
        }
    }
}