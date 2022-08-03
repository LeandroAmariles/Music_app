package com.example.musicapp.serviceIMPL;

import com.example.musicapp.Controller.SongController;
import com.example.musicapp.DTO.SongDTO;
import com.example.musicapp.Entity.Song;
import com.example.musicapp.MappersIMPL.MapperSong;
import com.example.musicapp.Repository.SongRepository;
import com.example.musicapp.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceIMPL implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private MapperSong mapper;

    @Override
    public List<SongDTO> getAllSongs() {
        List<Song> songs = songRepository.findAll();
        List<SongDTO> songDTOS= songs.stream().map((x)-> mapper.EntityToDto(x)).collect(Collectors.toList());
        return songDTOS;
    }

    @Override
    public List<SongDTO> saveSong(List<SongDTO> songDTOS) {
        List<Song> list = songDTOS.stream().map((x)-> mapper.DtoToEntity(x)).collect(Collectors.toList());
        list.stream().map((x)-> songRepository.save(x));
        return songDTOS;
    }

    @Override
    public SongDTO saveSingleSong(SongDTO songDTO) {
        Song dto = mapper.DtoToEntity(songDTO);
        songRepository.save(dto);
        return songDTO;
    }


}
