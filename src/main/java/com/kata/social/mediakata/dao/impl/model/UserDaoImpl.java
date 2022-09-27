package com.kata.social.mediakata.dao.impl.model;

import com.kata.social.mediakata.dao.abstracts.model.UserDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.entity.user.User;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoAbstract<User, Long> implements UserDao {

    public UserDaoImpl() {
        super();
    }
    @Override
    public Optional<User> getUserByEmail(String email) {
        TypedQuery<User> typedQuery = super.entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email);
        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }

    @Override
    public void create(User entity) {
        super.create(entity);
    }

    @Override
    public void update(User entity) {
        super.update(entity);
    }

    @Override
    public Optional<User> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void delete(User entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return super.existById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }
}
