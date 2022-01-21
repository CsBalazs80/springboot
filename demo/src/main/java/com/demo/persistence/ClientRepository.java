package com.demo.persistence;

import com.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> getClientByName(String name);

    // Provides CRUD interface
}
