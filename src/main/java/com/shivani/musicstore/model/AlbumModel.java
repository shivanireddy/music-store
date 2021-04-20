package com.shivani.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class AlbumModel {
    private int id;
    private String title;
    private String description;

    private List<String> artists;

}

