package com.kata.social.mediakata.service.impl.dto.user;

import com.kata.social.mediakata.dao.abstracts.dto.user.UserDtoDao;
import com.kata.social.mediakata.model.dto.user.UserDto;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.service.abstracts.dto.userDto.UserDtoService;
import com.kata.social.mediakata.service.impl.dto.pagination.PaginationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDtoServiceImp extends PaginationServiceImpl<Object> implements UserDtoService {

    private final UserDtoDao userDtoDao;

    @Autowired
    public UserDtoServiceImp(UserDtoDao userDtoDao) {
        this.userDtoDao = userDtoDao;
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userDtoDao.getUserDtoById(id);
    }

    @Override
    public PageDto<Object> getAllUserDto(Map<String, Object> parameters) {
       return super.getPageDto("getAllUsers", parameters);
    }
}
