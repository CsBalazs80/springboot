package com.demo.rest;

import com.demo.dto.ClientDTO;
import com.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ClientController {

    @Autowired
    private ClientService userService;

    @GetMapping("/by-name/{fullName}")
    public List<ClientDTO> getUserByFullName(@PathVariable String fullName) {
        return userService.getUserByFullName(fullName);
    }

    @PostMapping()
    public void saveClient(ClientDTO client) {
        userService.saveClient(client);
    }

    // Also implement delete, other methods, rest services on demand
}
