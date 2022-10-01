package com.kata.social.mediakata.dao.util;

import com.kata.social.mediakata.model.dto.user.UserDto;
import com.kata.social.mediakata.model.entity.user.User;

public class MappingUtils {

    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setAbout(user.getAbout());
        userDto.setStatus(user.getStatus());
        userDto.setAvatar(user.getAvatar());
        userDto.setEducation(user.getEducation());
        userDto.setCity(user.getCity());
        return userDto;
    }
}
