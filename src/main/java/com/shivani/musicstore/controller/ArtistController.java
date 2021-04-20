package com.shivani.musicstore.controller;

import com.shivani.musicstore.model.*;
import com.shivani.musicstore.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    private ArtistService artistService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetArtistsResponse getArtists() {
        List<ArtistModel> artistsList = artistService.getArtists();
        return new GetArtistsResponse(artistsList);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetArtistResponse getArtist(@PathVariable(name = "id") int id) {
        ArtistModel artist = artistService.getArtist(id);
        return new GetArtistResponse(artist);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable(name="id") int id) {
        artistService.deleteArtists(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateArtistResponse createArtist(@RequestBody CreateArtistRequest request) {
        ArtistModel artist = artistService.createArtist(request.getName());
        return new CreateArtistResponse(artist);
    }

}
