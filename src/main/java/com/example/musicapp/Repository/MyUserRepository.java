package com.example.musicapp.Repository;

import com.example.musicapp.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Long> {
}
