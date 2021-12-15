package com.tma.dataAccess;

import com.tma.documents.Album;
import com.tma.documents.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AlbumRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //repository.deleteAll();

        // save a couple of customers
        //repository.save(new Album("Blood Magick Necromance", new Band("Belphegor")));
        //repository.save(new Album("Reign in Blood", new Band("Slayer")));

        // fetch all customers
        System.out.println("Albums found with findAll():");
        System.out.println("-------------------------------");
        for (Album album : repository.findAll()) {
            System.out.println(album);
        }
        System.out.println();

        // fetch an individual album
        System.out.println("Album found with findByTitle('Blood Magick Necromance'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByTitle("Blood Magick Necromance"));

        System.out.println("Albums found with findByBand('Cytotoxin'):");
        System.out.println("--------------------------------");
        for (Album album : repository.findByBand(new Band("Cytotoxin"))) {
            System.out.println(album);
        }

    }

}