package com.kata.social.mediakata.dao.impl.dto;


import com.kata.social.mediakata.dao.abstracts.dto.userDto.UserDtoDao;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDtoDaoImp  implements UserDtoDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Optional<UserDto> getUserDtoById(Long id) {
        TypedQuery<UserDto> typedQuery = entityManager.createQuery("SELECT new com.kata.social.mediakata.model.dto.UserDto.UserDto(u.id,  u.firstName," +
                        " u.lastName, u.email, u.dateOfBirth, u.about, u.avatar, u.city, u.education) FROM User u WHERE u.id = :id", UserDto.class)
                .setParameter("id", id);
        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }
}
