package com.geekkk.springdemo.controller;

import com.geekkk.springdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello Homepage!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User User() {
        User user = new User();
        user.setId("1234");
        user.setName("stone");
        user.setEmail("info@stone.com");
        return user;
    }

    @GetMapping("/user/{id}/{username}")
    public User userByPathVariable(@PathVariable String id, @PathVariable("username") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail("info@stone.com");
        return user;
    }

    @GetMapping("/userrequest")
    public User userByRequestParams(
            @RequestParam String id,
            @RequestParam("username") String name,
            @RequestParam(required = false, defaultValue = "") String email
            ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail("info@stone.com");
        return user;
    }
}
