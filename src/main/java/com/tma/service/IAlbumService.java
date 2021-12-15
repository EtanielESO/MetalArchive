package com.tma.service;

import com.tma.documents.Album;

import java.util.Date;
import java.util.List;

public interface IAlbumService {
    List<Album> findAll();
    List<Album>  findByBandName(String bandName);
    Album findByTitle(String title);
    List<Album> findByReleaseDate(Date releaseDate);
    Album saveOrUpdateStudent(Album student);
    void deleteAlbumByTitle(String title);
}
