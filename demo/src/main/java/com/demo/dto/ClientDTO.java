package com.demo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String professionalEmail;
    private String fullName;
    
}
