package com.shivani.musicstore.service;

import com.shivani.musicstore.model.ArtistModel;
import java.util.*;

public interface ArtistService {
    ArtistModel getArtist(int id);
    List<ArtistModel> getArtists();
    void deleteArtists(int id);
    ArtistModel createArtist(String name);
}
