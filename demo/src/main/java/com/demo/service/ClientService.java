package com.demo.service;

import com.demo.dto.ClientDTO;
import com.demo.mapper.ClientMapper;
import com.demo.persistence.ClientRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

   private final ClientMapper USER_MAPPER = Mappers.getMapper(ClientMapper.class);

    @Autowired
    private ClientRepository userRepository;

    public List<ClientDTO> getUserByFullName(String fullName) {
        return userRepository.getClientByName(fullName).stream()
                .map(USER_MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    public void saveClient(ClientDTO client) {
        // use the conversion like previous way, userRepository provices CRUD
    }

    // Also implement delete on demand
}
