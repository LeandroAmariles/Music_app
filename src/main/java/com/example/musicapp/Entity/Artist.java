package com.example.musicapp.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "fullName",nullable = false)
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, //an album can at most have 1 artist)
    fetch = FetchType.LAZY,mappedBy = "artist")
    private List<Album> albums;


    @Override
    public String toString(){
        return String.format("Artist with id %d and name %s",id,fullName);
    }

}
