package com.tma.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Band {

    @JsonProperty("id")
    @Id
    public String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("formationDate")
    private Date formationDate;

    public Band (String name) {
        this.name = name;
    }

}
