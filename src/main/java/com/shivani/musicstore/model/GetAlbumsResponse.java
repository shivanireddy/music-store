package com.shivani.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class GetAlbumsResponse {

    private List<AlbumModel> albums;
}

