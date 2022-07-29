package com.example.demo.user;

import java.net.URI;
import java.util.List;

import com.example.demo.user.User;
import com.example.demo.user.UserDaoService;

import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import
        org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {

        User userFound = service.findOne(id);
        EntityModel entityModel = EntityModel.of(userFound);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(linkBuilder.withRel("bkp-users"));
        return entityModel;
        //service.findOne(id);
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = service.save(user);
    }

    @PostMapping("/users_resp")
    public ResponseEntity<Object> createUserResp(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // CREATED
        // /user/{id} savedUser.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
