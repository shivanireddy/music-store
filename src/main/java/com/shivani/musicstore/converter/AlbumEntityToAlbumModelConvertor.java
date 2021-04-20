package com.shivani.musicstore.converter;

import java.util.ArrayList;

import com.shivani.musicstore.entity.AlbumEntity;
import com.shivani.musicstore.entity.ArtistEntity;
import com.shivani.musicstore.model.AlbumModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class AlbumEntityToAlbumModelConvertor implements Converter<AlbumEntity, AlbumModel>{

    @Override
    public AlbumModel convert(AlbumEntity source) {

        if (source == null) {
            return null;
        }

        AlbumModel res = new AlbumModel(source.getId(), source.getTitle(), source.getDescription(), new ArrayList<String>());

        for (ArtistEntity artist: source.getArtists()) {
            res.getArtists().add(artist.getName());
        }

        return res;
    }
}
