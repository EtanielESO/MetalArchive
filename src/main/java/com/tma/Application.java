package com.tma;

import com.tma.service.IAlbumService;
import com.tma.service.impl.AlbumServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public IAlbumService albumService() {
        return new AlbumServiceImpl();
    }

    @Override
    public void run(String... args) throws Exception {}

}