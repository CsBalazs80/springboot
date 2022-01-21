package com.demo.rest;

import com.demo.dto.UserDTO;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/by-name/{fullName}")
    List<UserDTO> getUserByFullName(@PathVariable String fullName) {
        return userService.getUserByFullName(fullName);
    }
}
