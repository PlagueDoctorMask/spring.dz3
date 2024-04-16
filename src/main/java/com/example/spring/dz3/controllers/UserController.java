package com.example.spring.dz3.controllers;

import com.example.spring.dz3.domain.User;
import com.example.spring.dz3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user.getName(),user.getAge(),user.getEmail());
        return "User added from body!";
    }
}
