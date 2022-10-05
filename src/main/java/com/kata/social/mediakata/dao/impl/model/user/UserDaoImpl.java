package com.kata.social.mediakata.dao.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.UserDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoAbstract<User, Long> implements UserDao {

    @Override
    public Optional<User> getUserByEmail(String email) {
        TypedQuery<User> typedQuery = super.entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email);
        return SingleResultUtil.getSingleResultOrNull(typedQuery);
    }

    @Override
    public boolean existByMail(String mail) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = : mail", User.class);
        query.setParameter("mail", mail);
        if (SingleResultUtil.getSingleResultOrNull(query) == null) {
            return true;
        }
        return false;
    }
}
