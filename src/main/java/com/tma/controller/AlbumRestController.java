package com.tma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoCollection;
import com.tma.documents.Album;
import com.tma.documents.SingleCollection;
import com.tma.service.IAlbumService;
import com.tma.utils.ObjectMapperUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumRestController {

    private static final Logger logger = LogManager.getLogger(AlbumRestController.class);

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Gets the full list of Albums
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/getAllAlbums")
    public ResponseEntity<List<String>> getAllAlbums(){
        logger.info("Received http request to getAllAlbums");

        StringBuilder builder = new StringBuilder();
        List<Album> albumList = albumService.findAll();
        if(albumList.isEmpty()) {
            return new ResponseEntity("Couldn't retrieve any albums", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            for (Album album : albumList) {
                builder.append(album.getTitle());
                builder.append(" ,");
            }
        }
        String returnObject = ObjectMapperUtil.convertToString(albumList);

        logger.info("Successfully returned Album List : " + builder.toString());
        return new ResponseEntity(returnObject, HttpStatus.OK);
    }

    /**
     * Saves an album into the Database
     * @param album
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/saveAlbum")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody String album) {
        logger.info("Received http request to save: " + album);
        try {
            albumService.saveOrUpdateStudent(ObjectMapperUtil.mapper.readValue(album,Album.class));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity("Student added successfully", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        logger.info("Successfully saved Album: " + album);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    //TODO add logs to property file ?

    /**
     * Deletes an album defined by its title
     * @param title
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/delete/{title}")
    public ResponseEntity<?> deleteAlbumByAlbumTitle(@PathVariable String title) {
        logger.info("Received http request to delete album with title: " + title);
        albumService.deleteAlbumByTitle(albumService.findByTitle(title).getTitle());
        return new ResponseEntity("Album successfully removed from the archives", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/getResponse")
    public ResponseEntity<?> checkApi(@RequestBody String string){
        logger.info("Api received test request");
        return new ResponseEntity<>("Api successfully tested", HttpStatus.OK);
    }

    /**
     * Creates a collection with the given name
     * @param collectionName
     * @return the created collection
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/createCollection/{collectionName}")
    public ResponseEntity<?> createCollection(@PathVariable String collectionName) {
        logger.info("Creating " + collectionName + " collection");
        try{
            MongoCollection collection = mongoTemplate.createCollection(collectionName);
            return new ResponseEntity<>("Collection " + collectionName + " created", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed creating collection : " + e.getMessage());
        }
        return new ResponseEntity<>("Collection creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Gets all the existing collection names from database
     * @return the list of collection names
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/getAllCollections")
    public ResponseEntity<?> getAllCollections() {
        logger.info("Retrieving collections");
        ArrayList<SingleCollection> collectionSet = new ArrayList<>();
        Collection<String> collectionNamesSet = mongoTemplate.getCollectionNames();
        for(String name : collectionNamesSet){
            collectionSet.add(new SingleCollection(name));
        }
        ObjectMapperUtil.convertToString(collectionSet);
        logger.info("Retrieved " + collectionSet.size() + " collections");
        return new ResponseEntity<>(collectionSet, HttpStatus.OK);
    }

    /**
     * Gets all the existing collection names from database
     * @return the list of collection names
     */
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/deleteCollection/{collectionName}")
    public ResponseEntity<?> getAllCollections(@PathVariable String collectionName) {
        logger.info("Deleting collection " + collectionName);
        mongoTemplate.dropCollection(collectionName);
        logger.info("Deleted " + collectionName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
