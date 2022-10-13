package com.kata.social.mediakata.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {

    Long id;

    String firstName;

    String lastName;

    String email;

    LocalDate birthday;

    String aboutMe;

    String avatar;

    String city;

    String education;


}
