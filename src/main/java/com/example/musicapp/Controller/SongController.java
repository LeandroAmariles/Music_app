package com.example.musicapp.Controller;

import com.example.musicapp.DTO.SongDTO;
import com.example.musicapp.serviceIMPL.SongServiceIMPL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SongController {

    private final Logger log = LoggerFactory.getLogger(SongController.class);

    @Autowired
    private SongServiceIMPL songServiceIMPL;

    @PostMapping("/save")
    public ResponseEntity<List<SongDTO>> saveSongs(@RequestBody List<SongDTO> songDTOS){
        log.info("The songs have been added");
        return new ResponseEntity<List<SongDTO>>(songServiceIMPL.saveSong(songDTOS), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SongDTO>> listExistentSongs(){
        log.info("listing songs");
        return new ResponseEntity<>(songServiceIMPL.getAllSongs(),HttpStatus.OK);
    }

    @PostMapping("/save1")
    public ResponseEntity<SongDTO> saveSong(@RequestBody SongDTO songDTO){
        return new ResponseEntity<>(songServiceIMPL.saveSingleSong(songDTO), HttpStatus.OK);
    }
}
