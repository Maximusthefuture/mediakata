package com.kata.social.mediakata.dao.impl.dto;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.UserDtoDao;
import com.kata.social.mediakata.dao.abstracts.model.user.UserDao;
import com.kata.social.mediakata.dao.util.MappingUtils;
import com.kata.social.mediakata.model.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Repository
public class UserDtoDaoImpl implements UserDtoDao  {
    @Autowired
    UserDao userDao;

    @Override
    public List<UserDto> getItems(Map parameters) {
        int itemsOnPage = (int) parameters.get("itemsOnPage");
        int currentPage = (int) parameters.get("currentPage");

        List<UserDto> allItems = userDao.getAll().stream().map(user -> new MappingUtils().mapToUserDto(user)).toList();


        }
    }

    @Override
    public Long getItemsCount(Map parameters) {
        return userDao.getAll().stream().map(user -> new MappingUtils().mapToUserDto(user)).count();
    }


}
