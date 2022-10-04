package com.kata.social.mediakata.dao.abstracts.dto.userDto;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import com.kata.social.mediakata.model.entity.user.User;

import java.util.Optional;

public interface UserDtoDao  {

        Optional<UserDto> getUserDtoById(Long id);
    }


