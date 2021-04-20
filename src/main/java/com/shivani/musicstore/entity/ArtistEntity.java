package com.shivani.musicstore.entity;

import java.util.*;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "artist")
@Data
public class ArtistEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "album_artist", joinColumns = { @JoinColumn(name="artist_id") }, inverseJoinColumns = {@JoinColumn(name = "album_id")})
    private Set<AlbumEntity> albums;

    public ArtistEntity() {
        this.albums = new HashSet<AlbumEntity>();
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(obj);
    }

}
