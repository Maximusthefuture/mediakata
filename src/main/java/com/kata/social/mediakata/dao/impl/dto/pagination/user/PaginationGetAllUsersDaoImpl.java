package com.kata.social.mediakata.dao.impl.dto.pagination.user;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.PaginationDao;
import com.kata.social.mediakata.model.dto.UserDto.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class PaginationGetAllUsersDaoImpl<T> implements PaginationDao<UserDto> {

    @PersistenceContext
    protected EntityManager entityManager;
    @Override
    public List<UserDto> getItems(Map<String, Object> parameters) {
        int itemsOnPage = (int) parameters.get("itemsOnPage");
        int currentPage = (int) parameters.get("currentPage");
        TypedQuery<UserDto> list = entityManager.createQuery("SELECT  new com.kata.social.mediakata.model.dto.UserDto.UserDto(u.id,  u.firstName," +
                " u.lastName, u.email, u.dateOfBirth, u.about, u.avatar, u.city, u.education) FROM User u", UserDto.class)
                .setFirstResult((currentPage-1) * itemsOnPage).setMaxResults(itemsOnPage);
        return list.getResultList();
    }

    @Override
    public Long getItemsCount(Map<String, Object> parameters) {
        TypedQuery<UserDto> list = entityManager.createQuery("SELECT new com.kata.social.mediakata.model.dto.UserDto.UserDto(u.id,  u.firstName," +
                " u.lastName, u.email, u.dateOfBirth, u.about, u.avatar, u.city, u.education) FROM User u", UserDto.class);
        return (long) list.getResultList().size();
    }
}
