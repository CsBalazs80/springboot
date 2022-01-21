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
public class UserService {

   private final ClientMapper USER_MAPPER = Mappers.getMapper(ClientMapper.class);

    @Autowired
    private ClientRepository userRepository;

    public List<ClientDTO> getUserByFullName(String fullName) {
        return userRepository.getUserByName(fullName).stream()
                .map(USER_MAPPER::toDTO)
                .collect(Collectors.toList());
    }
}
