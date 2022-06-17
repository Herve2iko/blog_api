package com.example.crud1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    
    @GetMapping(path = "/hello-world")
    public String Hello(){
        return "Hello World";
    }
    @GetMapping(path = "/hello-bean")
    public List <HelloBean> helloBean(){
        return List.of(new HelloBean("hello",3));
    }
}
