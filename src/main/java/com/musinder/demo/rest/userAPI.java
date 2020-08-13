package com.musinder.demo.rest;

import com.musinder.demo.models.User;
import com.musinder.demo.repositories.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import io.github.jhipster.web.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@Transactional
@Log4j2
public class userAPI {

    @Autowired
    private UserRepository userRepository;

    String ENTITY_NAME = "USER";

    @GetMapping("")
    public List<User> getAllUsers(){
        log.info("GET ALL USERS");
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable long id){
        log.info("GET ONE USER");
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found!"));
        return user;
    }

    @PostMapping("/new")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        log.info("ADD new User");
        userRepository.save(user);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Musinder", true, ENTITY_NAME, user.getId().toString()))
                .body(user);
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<User> modifyUser(@PathVariable long id , @Valid @RequestBody User user){
        log.info("Modify User with id :"+id);
        User oldUser = getOneUser(id);
        user.setId(oldUser.getId());
        userRepository.save(user);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("Musinder", true, ENTITY_NAME, user.getId().toString()))
                .body(user);
    }
}
