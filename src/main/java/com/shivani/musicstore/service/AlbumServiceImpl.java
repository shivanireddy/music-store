package com.shivani.musicstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.*;

import com.shivani.musicstore.entity.AlbumEntity;
import com.shivani.musicstore.entity.ArtistEntity;
import com.shivani.musicstore.model.AlbumModel;
import com.shivani.musicstore.repository.AlbumRepository;
import com.shivani.musicstore.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final Converter<AlbumEntity, AlbumModel> converter;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository, Converter<AlbumEntity, AlbumModel> converter) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.converter = converter;
    }

    @Override
    public AlbumModel getAlbum(int id) {

        Optional<AlbumEntity> album = albumRepository.findById(id);

        if (album.isPresent()) {
            AlbumEntity entity = album.get();
            return converter.convert(entity);
        }

        return null;
    }

    @Override
    public List<AlbumModel> getAlbums() {

        List<AlbumEntity> list = albumRepository.findAll();
        List<AlbumModel> res = new ArrayList<>();

        for (AlbumEntity entity: list) {
            res.add(converter.convert(entity));
        }

        return res;
    }

    @Override
    public void deleteAlbum(int id) {
        albumRepository.deleteById(id);

    }

    @Override
    public AlbumModel createAlbum(String title, String description, Set<String> artists) {

        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setTitle(title);
        albumEntity.setDescription(description);

        for (String name: artists) {

            List<ArtistEntity> artistEntityList = artistRepository.findByName(name);
            ArtistEntity artistEntity;
            if (artistEntityList == null || artistEntityList.size() == 0) {
                ArtistEntity tmpArtistEntity = new ArtistEntity();
                tmpArtistEntity.setName(name);
                artistEntity = artistRepository.save(tmpArtistEntity);
            }
            else {
                artistEntity = artistEntityList.get(0);
            }

            albumEntity.getArtists().add(artistEntity);
        }

        AlbumEntity savedAlbumEntity = albumRepository.save(albumEntity);

        return converter.convert(savedAlbumEntity);
    }

}
