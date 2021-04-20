package com.shivani.musicstore.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.*;

@Entity
@Table(name = "album")
@Data
public class AlbumEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "album_artist", joinColumns = { @JoinColumn(name="album_id") }, inverseJoinColumns = {@JoinColumn(name = "artist_id")})
    private Set<ArtistEntity> artists;

    public AlbumEntity() {
        this.artists = new HashSet<ArtistEntity>();
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
