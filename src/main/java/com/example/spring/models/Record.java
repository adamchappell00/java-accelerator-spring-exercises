package com.example.spring.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Record {
    private int id;

    @NotEmpty(message = "You must have an artist name")
    private String artist;

    @NotEmpty(message = "You must have an album name")
    private String album;

    @Size(min = 4, max = 4, message = "Year must be 4 digits")
    private String year;

    public Record() { }

    public Record(String artist, String album, int id, String year) {
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.year = year;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {return year;}
    public void setYear(String year) {this.year = year;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id && year == record.year && Objects.equals(artist, record.artist) && Objects.equals(album, record.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, album, year);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", year=" + year +
                '}';
    }
}
