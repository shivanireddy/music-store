package com.shivani.musicstore.repository;

import com.shivani.musicstore.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {

}

