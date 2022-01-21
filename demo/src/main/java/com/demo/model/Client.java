package com.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    // ... More fields to be written

}
