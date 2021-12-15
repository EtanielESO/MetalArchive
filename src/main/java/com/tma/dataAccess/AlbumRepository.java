package com.tma.dataAccess;

import java.util.List;

import com.tma.documents.Album;
import com.tma.documents.Band;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {

    public Album findByTitle(String title);
    public List<Album> findByBand(Band band);
    public void deleteByTitle(String title);

}