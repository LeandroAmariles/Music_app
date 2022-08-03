package com.example.musicapp.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(name = "created_at",nullable = false,updatable = false)
    private long createdAt;

    @LastModifiedDate
    @Column(name = "last_modifiqued", nullable = false)
    private long lastModifiedAt;

    @NotNull
    @Column(name="title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name="description", columnDefinition = "TEXT")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, // an album may have more than one song
            fetch = FetchType.LAZY, mappedBy = "album")
    private List<Song> songs;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)// more than one album may belong to one artist
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Override
    public String toString(){
        return String.format("Album with id %d anf title %s", id, title);
    }



}
