package com.kata.social.mediakata.dao.impl.dto;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.UserDtoDao;
import com.kata.social.mediakata.dao.abstracts.model.user.UserDao;
import com.kata.social.mediakata.dao.util.MappingUtils;
import com.kata.social.mediakata.dao.util.PageListUtils;
import com.kata.social.mediakata.model.dto.user.UserDto;
import com.kata.social.mediakata.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Repository
public class UserDtoDaoImpl implements UserDtoDao  {

    UserDao userDao;

    @Autowired
    public UserDtoDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> getItems(Map parameters) {

        int itemsOnPage = (int) parameters.get("itemsOnPage");
        int currentPage = (int) parameters.get("currentPage");

        List<UserDto> allItems = userDao.getAll().stream().map(user -> new MappingUtils().mapToUserDto(user)).toList();

        return PageListUtils.getPage(allItems,currentPage,itemsOnPage);
    }

    @Override
    public Long getItemsCount(Map parameters) {
        return userDao.getAll().stream().map(user -> new MappingUtils().mapToUserDto(user)).count();
    }
}
