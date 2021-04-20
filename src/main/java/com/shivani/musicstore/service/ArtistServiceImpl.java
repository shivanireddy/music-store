package com.shivani.musicstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;

import com.shivani.musicstore.entity.ArtistEntity;
import com.shivani.musicstore.model.ArtistModel;
import com.shivani.musicstore.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;


@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, Converter<ArtistEntity, ArtistModel> converter) {
        this.artistRepository = artistRepository;
        this.converter = converter;
    }

    private final ArtistRepository artistRepository;
    private final Converter<ArtistEntity, ArtistModel> converter;

    @Override
    public ArtistModel getArtist(int id) {

        Optional<ArtistEntity> artist = artistRepository.findById(id);

        if (artist.isPresent()) {
            ArtistEntity entity = artist.get();
            return converter.convert(entity);
        }

        return null;
    }

    @Override
    public List<ArtistModel> getArtists() {

        List<ArtistEntity> list = artistRepository.findAll();
        List<ArtistModel> res = new ArrayList<>();

        for (ArtistEntity entity: list) {
            res.add(converter.convert(entity));
        }

        return res;
    }

    @Override
    public void deleteArtists(int id) {
        artistRepository.deleteById(id);
    }

    @Override
    public ArtistModel createArtist(String name) {

        ArtistEntity entity = new ArtistEntity();
        entity.setName(name);

        ArtistEntity savedEntity = artistRepository.save(entity);

        return converter.convert(savedEntity);
    }

}
