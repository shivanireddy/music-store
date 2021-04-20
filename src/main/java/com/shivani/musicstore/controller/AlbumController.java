package com.shivani.musicstore.controller;

import com.shivani.musicstore.model.*;
import com.shivani.musicstore.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAlbumsResponse getAlbums() {
        List<AlbumModel> albumsList = albumService.getAlbums();
        return new GetAlbumsResponse(albumsList);

    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAlbumResponse getAlbum(@PathVariable(name = "id") int id) {
        AlbumModel artist = albumService.getAlbum(id);
        return new GetAlbumResponse(artist);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable(name="id") int id) {
        albumService.deleteAlbum(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAlbumResponse createAlbum(@RequestBody CreateAlbumRequest request) {
        AlbumModel artist = albumService.createAlbum(request.getTitle(), request.getDescription(), request.getArtists());
        return new CreateAlbumResponse(artist);

    }
}
