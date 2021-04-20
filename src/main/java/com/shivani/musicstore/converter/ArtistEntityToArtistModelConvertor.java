package com.shivani.musicstore.converter;

import com.shivani.musicstore.entity.ArtistEntity;
import com.shivani.musicstore.model.ArtistModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ArtistEntityToArtistModelConvertor implements Converter<ArtistEntity, ArtistModel> {

    @Override
    public ArtistModel convert(ArtistEntity source) {

        if (source == null)
            return null;

        return new ArtistModel(source.getId(), source.getName());
    }

}
