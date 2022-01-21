package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.mapper.UserMapper;
import com.demo.persistence.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

   private final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUserByFullName(String fullName) {
        return userRepository.getUserByName(fullName).stream()
                .map(USER_MAPPER::toDTO)
                .collect(Collectors.toList());
    }
}
