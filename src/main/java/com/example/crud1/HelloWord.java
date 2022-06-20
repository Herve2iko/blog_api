package com.example.crud1;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String Hello(@RequestHeader(name = "accept-languge", required = false) Locale locale){
        return messageSource.getMessage("hello.message",null, locale);
    }

    @GetMapping(path = "/hello-int")
    public String Helloint(@RequestHeader(name = "accept-languge", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null, locale);
    }
    @GetMapping(path = "/hello-bean")
    public List <HelloBean> helloBean(){
        return List.of(new HelloBean("hello",3));
    }
}
