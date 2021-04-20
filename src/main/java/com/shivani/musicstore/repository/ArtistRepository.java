package com.shivani.musicstore.repository;

import com.shivani.musicstore.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {

    List<ArtistEntity> findByName(String name);
}
