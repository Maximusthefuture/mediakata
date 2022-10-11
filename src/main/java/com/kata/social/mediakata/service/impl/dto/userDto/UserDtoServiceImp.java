package com.kata.social.mediakata.service.impl.dto.userDto;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.PaginationDao;
import com.kata.social.mediakata.dao.abstracts.dto.userDto.UserDtoDao;
import com.kata.social.mediakata.dao.impl.dto.pagination.user.PaginationGetAllUsersDaoImpl;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.service.abstracts.dto.pagination.PaginationService;
import com.kata.social.mediakata.service.abstracts.dto.userDto.UserDtoService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import com.kata.social.mediakata.service.impl.dto.pagination.PaginationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDtoServiceImp extends PaginationServiceImpl<Object> implements UserDtoService {

    private final UserDtoDao userDtoDao;

//    @Autowired
    private PaginationDao<Object> paginationDao;

    @Autowired
    public UserDtoServiceImp(UserDtoDao userDtoDao, PaginationDao<Object> paginationDao) {
        this.userDtoDao = userDtoDao;
        this.paginationDao = paginationDao;
        //?????Как правильно работать с  setPaginationDaos???
        Map<String, PaginationDao<Object>> map = new HashMap<>();
        map.put("PaginationGetAllUsersDaoImpl", paginationDao);
        setPaginationDaos(map);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userDtoDao.getUserDtoById(id);
    }

    @Override
    public PageDto<Object> getAllUserDto(Map<String, Object> parameters) {
       return super.getPageDto("PaginationGetAllUsersDaoImpl", parameters);
    }
}
