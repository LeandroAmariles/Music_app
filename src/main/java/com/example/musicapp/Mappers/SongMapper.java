package com.example.musicapp.Mappers;

import com.example.musicapp.DTO.SongDTO;
import com.example.musicapp.Entity.Song;

public interface SongMapper {

    public SongDTO EntityToDto(Song song);

    public Song DtoToEntity(SongDTO songDTO);

}
