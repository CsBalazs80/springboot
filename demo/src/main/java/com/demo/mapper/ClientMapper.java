package com.demo.mapper;

import com.demo.dto.UserDTO;
import com.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "fullName")
    @Mapping(target = "email", source = "professionalEmail")
    User toModel(UserDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "email", target = "professionalEmail")
    UserDTO toDTO(User model);
}
