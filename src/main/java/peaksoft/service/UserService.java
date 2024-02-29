package peaksoft.service;

import peaksoft.entity.User;

public interface UserService {
    String saveUser(User user);
    User login (User user) throws Exception;
    User findByUserId(Long userId) throws Exception;
   User  findUserByName(String name);

}
