package com.example.musicapp.Entity;

import com.example.musicapp.Enum.UserRole;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "username",nullable = false,unique = true)
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private UserRole role;


    @Override
    public String toString(){
        return String.format("user with id %d and username %s", id, userName);
    }
}
