package com.kata.social.mediakata.model.dto;


import com.kata.social.mediakata.model.entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
