package com.tma.documents;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Band {

    @Id
    public String id;
    private String bandName;
    private Date formationDate;

    public Band() {};
    public Band(String bandName) {
        setBandName(bandName);
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Date getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(Date formationDate) {
        this.formationDate = formationDate;
    }
}
