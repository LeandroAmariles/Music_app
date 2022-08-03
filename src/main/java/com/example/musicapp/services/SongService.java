package com.example.musicapp.services;

import com.example.musicapp.DTO.SongDTO;
import com.example.musicapp.Entity.Song;

import java.util.List;

public interface SongService {

    public List<SongDTO> getAllSongs();

    public List<SongDTO> saveSong(List<SongDTO> songDTOS);

    public SongDTO saveSingleSong(SongDTO songDTO);
}
