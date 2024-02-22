package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Repository;
import peaksoft.entity.*;
import peaksoft.repo.UserPepo;

import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepoImpl implements UserPepo {

    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public String saveUser(User user) {
        UserInfo userInfo = new UserInfo();
        Image image = new Image();
        List<Comment> comments = new ArrayList<>();

        user.setComments(comments);
        user.setImage(image);
        user.setUserInfo(userInfo);

        entityManager.persist(user);
        return  "User saved !! ";
    }

    @Override
    public User login(User user) throws Exception {
        User currentUser = entityManager.createQuery("select u from User u where u.user_name = :username and u.password = :password", User.class)
                .setParameter("username", user.getUser_name())
                .setParameter("password", user.getPassword())
                .getSingleResult();
        if (currentUser != null){
            return currentUser;
        } else {
            throw new Exception("Username or password invalid");
        }
    }

    @Override
    public User findByUserId(Long userId) throws Exception {
        User currentUser = entityManager.createQuery("select u from User u where u.id = :userID", User.class)
                .setParameter("userID", userId)
                .getSingleResult();
        if (currentUser != null){
            return currentUser;
        } else {
            throw new Exception("Username or password invalid");
        }

    }



}
