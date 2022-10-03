package com.kata.social.mediakata.service.impl.dto.userDto;

import com.kata.social.mediakata.dao.abstracts.dto.userDto.UserDtoDao;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import com.kata.social.mediakata.service.abstracts.dto.userDto.UserDtoService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDtoServiceImp extends GenericServiceAbstract <UserDto, Long> implements UserDtoService {

    private final UserDtoDao userDtoDao;

    @Autowired
    public UserDtoServiceImp(UserDtoDao userDtoDao) {
        super(userDtoDao);
        this.userDtoDao = userDtoDao;
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userDtoDao.getUserDtoById(id);
    }
}
