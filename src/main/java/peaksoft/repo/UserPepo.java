package peaksoft.repo;

import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;

public interface UserPepo {
    String saveUser(User user);
    User login (User user) throws Exception;
    User findByUserId(Long userId) throws Exception;
    User  findUserByName(String name);


}
