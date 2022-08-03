package com.example.musicapp.MappersIMPL;

import com.example.musicapp.DTO.SongDTO;
import com.example.musicapp.Entity.Song;
import com.example.musicapp.Mappers.SongMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperSong implements SongMapper {
    @Override
    public SongDTO EntityToDto(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setDescription(song.getDescription());
        songDTO.setId(song.getId());
        songDTO.setCreatedAt(song.getCreatedAt());
        songDTO.setLength(song.getLength());
        songDTO.setTitle(song.getTitle());
        songDTO.setLastModifiedAt(song.getLastModifiedAt());
        return songDTO;
    }

    @Override
    public Song DtoToEntity(SongDTO songDTO) {
        Song song = new Song();
        song.setId(songDTO.getId());
        song.setDescription(songDTO.getDescription());
        song.setLength(songDTO.getLength());
        song.setCreatedAt(song.getCreatedAt());
        song.setTitle(songDTO.getTitle());
        song.setLastModifiedAt(songDTO.getLastModifiedAt());
        return song;
    }
}
