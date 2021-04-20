package com.shivani.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class CreateAlbumRequest {

    private String title;
    private String description;

    private Set<String> artists;


}
