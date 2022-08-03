package com.example.musicapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {

    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
    private String title;
    private String description;
    private double length;

}
