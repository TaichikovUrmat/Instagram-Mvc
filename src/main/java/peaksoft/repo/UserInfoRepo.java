package peaksoft.repo;

import peaksoft.entity.UserInfo;

public interface UserInfoRepo {
    String saveUserInfo(Long userId,UserInfo userInfo);
    UserInfo findUserInfoByUserID(Long userID) throws Exception;
    String delete(Long userInfoID);
    String update(Long userId, UserInfo newuserInfo);
    UserInfo findUserInfoById(Long id);
    UserInfo findById(Long id);




}
