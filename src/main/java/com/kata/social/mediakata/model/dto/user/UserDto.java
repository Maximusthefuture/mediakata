package com.kata.social.mediakata.model.dto.user;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String about;

    private String status;

    private String avatar;

    private String education;

    private String city;
}
