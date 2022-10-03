package com.kata.social.mediakata.model.dto.UserDto;

import com.kata.social.mediakata.model.entity.user.User;
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

    public UserDto (User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthday = user.getDateOfBirth();
        this.aboutMe = user.getAbout();
        this.avatar = user.getAvatar();
        this.education = user.getEducation();
        this.city = user.getCity();
    }
}
