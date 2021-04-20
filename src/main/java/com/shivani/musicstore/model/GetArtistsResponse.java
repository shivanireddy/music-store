package com.shivani.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;
import java.util.ArrayList;
@Data
@AllArgsConstructor
public class GetArtistsResponse {

    private List<ArtistModel> artists = new ArrayList<>();

}
