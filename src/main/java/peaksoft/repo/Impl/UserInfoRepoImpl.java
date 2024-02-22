package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repo.UserInfoRepo;
import peaksoft.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class UserInfoRepoImpl implements UserInfoRepo {

    @PersistenceContext
    private final EntityManager entityManager;
    private final UserService userService;

    @Override
    public String saveUserInfo(Long userId, UserInfo userInfo) {
        User user = entityManager.find(User.class, userId);
        List<Post> posts = new ArrayList<>();

        user.setUserInfo(userInfo);
        user.setPosts(posts);

        entityManager.persist(userInfo);

        return "n";


    }

    @Override
    public UserInfo findUserInfoByUserID(Long userID) throws Exception {
        UserInfo currentUser = entityManager.createQuery(
                        "select us from UserInfo us inner join User u on us.id= u.id where us.id = :userID", UserInfo.class)
                .setParameter("userID", userID)
                .getSingleResult();

        if (currentUser != null) {
            return currentUser;
        } else {
            throw new Exception("User not found");
        }
    }
    @Override
    public String delete(Long userInfoID) {
//        UserInfo userInfo = entityManager.find(UserInfo.class, userInfoID);
//        entityManager.remove(userInfo);

        entityManager.createQuery("DELETE FROM UserInfo WHERE id = :courseId")
                .setParameter("courseId",userInfoID)
                .executeUpdate();

        return "deleted !!! ";
    }
    @Override @Transactional
    public String update(Long userId, UserInfo newuserInfo) {
        UserInfo userInfoById = findUserInfoById(userId);
        userInfoById.setFullName(newuserInfo.getFullName());
        userInfoById.setBiography(newuserInfo.getBiography());
        userInfoById.setGender(newuserInfo.getGender());
        userInfoById.setImage(newuserInfo.getImage());
//        entityManager.persist(newuserInfo);
        return "updated";
    }

    @Override
    public UserInfo findUserInfoById(Long id) {
        return entityManager.find(UserInfo.class,id);
    }

    @Override
    public UserInfo findById(Long id) {
        return entityManager.find(UserInfo.class,id);
    }
}
