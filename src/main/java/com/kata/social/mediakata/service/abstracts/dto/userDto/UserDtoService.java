package com.kata.social.mediakata.service.abstracts.dto.userDto;

import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import com.kata.social.mediakata.service.abstracts.GenericService;

import java.util.Optional;

public interface UserDtoService extends GenericService<UserDto, Long> {
    @Override
    Optional<UserDto> getById(Long id);
}
