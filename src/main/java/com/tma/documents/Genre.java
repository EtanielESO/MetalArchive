package com.tma.documents;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    BM("Black Metal"),
    DM("Death Metal"),
    TM("Trash Metal"),
    ST("Stoner"),
    DoM("Doom Metal"),
    BDM("Brutal Death Metal"),
    TDM("Technical Death Metal"),
    GDC("Grindcore");

    @JsonProperty("genreName")
    private final String genreName;

    Genre(final String genreName){
        this.genreName = genreName;
    }

    @Override
    public String toString(){
        return genreName;
    }

}
