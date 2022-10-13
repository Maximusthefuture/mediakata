package com.kata.social.mediakata.service.abstracts.dto.userDto;

import com.kata.social.mediakata.model.dto.user.UserDto;
import com.kata.social.mediakata.model.dto.page.PageDto;

import java.util.Map;
import java.util.Optional;

public interface UserDtoService {

    Optional<UserDto> getById(Long id);
    PageDto<Object> getAllUserDto(Map<String, Object> parameters);
}
