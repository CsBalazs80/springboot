package com.demo.mapper;

import com.demo.dto.ClientDTO;
import com.demo.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "fullName")
    @Mapping(target = "email", source = "professionalEmail")
    Client toModel(ClientDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "email", target = "professionalEmail")
    ClientDTO toDTO(Client model);
}
