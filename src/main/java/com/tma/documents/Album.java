package com.tma.documents;

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Albums")
public class Album {

    @Id
    public String id;

    public String title;
    public Band band;
    public Date releaseDate;

    @Bean
    public Album album() {
        return new Album();
    }
    /** Default Constructor */
    public Album(){}

    /** Constructor */
    public Album(String title, Band band, Date releaseDate){
        setTitle(title);
        setBand(band);
        setReleaseDate(releaseDate);
    }

    @Override
    public String toString() {
        return String.format(
                "Album[id=%s, title='%s', band='%s']",
                id, title, band.getBandName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
