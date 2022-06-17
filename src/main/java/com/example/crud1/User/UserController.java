package com.example.crud1.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    
    @Autowired
    private UserServices services;

    @GetMapping(path = "/list")
    public List<User>allUsers(){
        return services.findAll();
    }
    @GetMapping(path = "/{id}")
    public User UserOne(@PathVariable int id){
        return services.findOne(id);
    }

    
    @PostMapping(path = "/create")
    public ResponseEntity<Object> CreateUser(@RequestBody User user){
        User UserAdd= services.addUser(user);

        URI locationUri = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(UserAdd.getId()).toUri();
        
        return ResponseEntity.created(locationUri).build();
    }
}
