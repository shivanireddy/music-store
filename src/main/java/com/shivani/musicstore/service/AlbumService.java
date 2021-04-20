package com.shivani.musicstore.service;

import com.shivani.musicstore.model.AlbumModel;

import java.util.List;
import java.util.Set;
import java.util.*;

public interface AlbumService {
    AlbumModel getAlbum(int id);
    List<AlbumModel> getAlbums();
    void deleteAlbum(int id);
    AlbumModel createAlbum(String title, String description, Set<String> artists);

}
