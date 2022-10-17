package com.kata.social.mediakata.dao.abstracts.dto.user;

import com.kata.social.mediakata.model.dto.user.UserDto;

import java.util.Optional;

public interface UserDtoDao  {

        Optional<UserDto> getUserDtoById(Long id);
    }


