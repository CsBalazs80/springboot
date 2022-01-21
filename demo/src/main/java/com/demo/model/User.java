package com.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

}
