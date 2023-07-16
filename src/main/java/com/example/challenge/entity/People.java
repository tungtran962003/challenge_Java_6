package com.example.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "firstName")
    private String first_name;

    @Column(name = "lastName")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "ipAddress")
    private String ip_address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "country")
    private String country;

    @Column(name = "job")
    private String job;

    @Column(name = "company")
    private String company;

    @Column(name = "salary")
    private String salary;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "slogan")
    private String slogan;
}
