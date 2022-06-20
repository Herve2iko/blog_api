package com.example.crud1.User;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
    
    @Autowired
    private UserServices services;

    @GetMapping(path = "/list")
    public List<User>allUsers(){
        return services.findAll();
    }
    @GetMapping(path = "/{id}")
    public User UserOne(@PathVariable int id){
        User user = services.findOne(id);
        if(user == null){
            throw new UserNotFoundException("user with id-"+id+" not exist");
        }
    
        // Resource<User> resource = new Resource<User>(user);
		
		// ControllerLinkBuilder linkTo = 
		// 		linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		// resource.add(linkTo.withRel("all-users"));
        return user;
    }
    
    @DeleteMapping(path = "/{id}")
    public User deleteUser(@PathVariable int id){
        User user = services.deleteUser(id);
        if(user == null){
            throw new UserNotFoundException("user with id-"+id+" not exist");
        }
        return user;
    }

    
    @PostMapping(path = "/create")
    public ResponseEntity<Object> CreateUser(@RequestBody User user){
        User UserAdd= services.addUser(user);

        URI locationUri = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .buildAndExpand(UserAdd.getId()).toUri();
        
        return ResponseEntity.created(locationUri).build();
    }
}
