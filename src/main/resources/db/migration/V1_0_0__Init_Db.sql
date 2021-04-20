CREATE SEQUENCE album_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE album (
  id integer NOT NULL DEFAULT nextval('album_id_seq'),
  title VARCHAR (255),
  description VARCHAR (255),
  PRIMARY KEY (id));
  
 CREATE SEQUENCE artist_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE artist (
  id integer NOT NULL DEFAULT nextval('artist_id_seq'),
  name VARCHAR (255),
  PRIMARY KEY (id));
  
 CREATE TABLE album_artist (
  album_id integer NOT NULL ,
  artist_id integer NOT NULL ,
  PRIMARY KEY (album_id , artist_id));

INSERT INTO album(id, title, description) VALUES (1, 'Abbey Road', 'rock/pop'), (2, 'Sticky Fingers', 'rock'), (3, 'Dark Side of the Moon', 'rock');
INSERT INTO artist(id, name) VALUES (1, 'The Beatles'), (2, 'The Rolling Stones'), (3, 'Pink Floyd');
INSERT INTO album_artist(album_id, artist_id) VALUES (1,1), (2,2), (3,3);
