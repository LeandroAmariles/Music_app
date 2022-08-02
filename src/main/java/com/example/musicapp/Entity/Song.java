package com.example.musicapp.Entity;


import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private long createdAt;

    @LastModifiedDate
    @Column(name="last_modified_at", nullable = false)
    private long lastModifiedAt;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="lenght", columnDefinition = "double default 0.0")
    private double lenght;

    @NotNull// A song can not exist with out album
    @ManyToOne(fetch = FetchType.LAZY, optional = false)// a song can have one album
    @JoinColumn(name="album_id",nullable = false)
    private Album album;

    @ManyToMany(mappedBy = "songs") // a song may appear in more than one playlist
    private List<PlayList> playList;

    @Override
    public String toString(){
        return String.format("Song with id %d and title %s", id,title);
    }
}
