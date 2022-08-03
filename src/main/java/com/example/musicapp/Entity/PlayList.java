package com.example.musicapp.Entity;

import com.example.musicapp.Enum.PlayListCategory;
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

public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private long createdAt;

    @LastModifiedDate
    @Column(name="Last_modified_at", nullable = false)
    private long lastModifiedAt;

    @NotNull
    @Column(name="title")
    private String title;


    @Column(name="description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private PlayListCategory category;



    // a playList can exist without having any song
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})// a playlist can have more than one song and a song may appear in more tha one playlist)
    @JoinTable(name="songs",
    joinColumns = @JoinColumn(name="playlist_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="song_id",referencedColumnName = "id"))
   /*
    @JoinTable annotation is used to join two table using a third table.
    This third table associates two table by their Ids. To define @JoinTable we can use below attributes.
        name: This is the name of third table.
        joinColumns: Assign the column of third table related to entity itself.
        inverseJoinColumns: Assign the column of third table related to associated entity.
     */
    private List<Song> songs;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private MyUser createdBy;

    @Override
    public String toString(){
        return String.format("PlayList with id %d and title %s", id, title);
    }

}
