package com.tma.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Albums")
@Data
public class Album {

    @JsonProperty("id")
    @Id
    public String id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("band")
    public Band band;
    @JsonProperty("releaseDate")
    public Date releaseDate;
    @JsonProperty("label")
    public String label;
    @JsonProperty("link")
    public String link;
    @JsonProperty("albumCover")
    public String albumCover;
    @JsonProperty("genre")
    public List<Genre> genre;

}
