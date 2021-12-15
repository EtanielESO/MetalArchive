package com.tma.service.impl;

import com.tma.dataAccess.AlbumRepository;
import com.tma.documents.Album;
import com.tma.documents.Band;
import com.tma.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> findAll(){
        return albumRepository.findAll();
    }

    @Override
    public List<Album>  findByBandName(String bandName){
        return albumRepository.findByBand(new Band(bandName));
    }

    @Override
    public Album findByTitle(String title){
        return albumRepository.findByTitle(title);
    }

    //TODO Add release date search
    public List<Album> findByReleaseDate(Date releaseDate){
        return null;
    }

    @Override
    public Album saveOrUpdateStudent(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbumByTitle(String title) {
        albumRepository.deleteByTitle(title);
    }


}
