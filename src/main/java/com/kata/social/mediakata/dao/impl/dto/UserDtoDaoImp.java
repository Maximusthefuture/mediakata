package com.kata.social.mediakata.dao.impl.dto;


import com.kata.social.mediakata.dao.abstracts.dto.userDto.UserDtoDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDtoDaoImp extends GenericDaoAbstract <UserDto, Long> implements UserDtoDao {

    @Override
    public Optional<UserDto> getUserDtoById(Long id) {
        TypedQuery<UserDto> typedQuery = super.entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", UserDto.class)
                .setParameter("id", id);
        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }
}
