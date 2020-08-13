package com.musinder.demo;

import com.musinder.demo.enumerations.Role;
import com.musinder.demo.models.Movie;
import com.musinder.demo.models.Music;
import com.musinder.demo.models.User;
import com.musinder.demo.repositories.MovieRepository;
import com.musinder.demo.repositories.MusicRepository;
import com.musinder.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@SpringBootApplication

public class MusinderApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private MovieRepository movieRepository;

    private PasswordEncoder passwordEncoder;



    public static void main(String[] args) {
        SpringApplication.run(MusinderApplication.class, args);
    }

    LocalDate date = LocalDate.now();

    @Override
    public void run(String... args) throws Exception {
//       User user = userRepository.save(User
//               .builder()
//               .email("daoulat.khalil@gmail.com")
//               .name("Khalil")
//               .lastName("Daoulat")
//               .number("0612457896")
//               .birthDay(date)
//               .build());
//
//       Music music = musicRepository.save(Music
//               .builder()
//               .artiste("Bones M")
//               .name("Daddy Cool")
//               .date(date)
//               .user(user)
//               .build());
//
//       Movie movie = movieRepository.save(Movie
//               .builder()
//               .user(user)
//               .name("Catch me if can")
//               .description("Catching a money faker")
//               .date(date)
//               .build());

    }
}
