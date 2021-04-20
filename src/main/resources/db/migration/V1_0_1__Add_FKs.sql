ALTER TABLE if EXISTS album_artist
ADD CONSTRAINT album_fk
FOREIGN KEY (album_id) REFERENCES album;

ALTER TABLE if EXISTS album_artist
ADD CONSTRAINT artist_fk
FOREIGN KEY (artist_id) REFERENCES artist;
