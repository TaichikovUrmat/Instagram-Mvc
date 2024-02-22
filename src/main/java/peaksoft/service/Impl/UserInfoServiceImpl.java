package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.UserInfo;
import peaksoft.repo.UserInfoRepo;
import peaksoft.repo.UserPepo;
import peaksoft.service.UserInfoService;

@Service
@Transactional
@RequiredArgsConstructor

public class UserInfoServiceImpl implements UserInfoService {

private final UserInfoRepo userInfoRepo;
private final UserPepo userPepo;
    @Override
    public String saveUserInfo(Long userId, UserInfo userInfo) {

        userInfoRepo.saveUserInfo(userId,userInfo);
        return "ssss";
    }

    @Override
    public UserInfo findUserInfoByUserID(Long userID) throws Exception {
       return userPepo.findByUserId(userID).getUserInfo();
    }

    @Override
    public String delete(Long userInfoID) {
     userInfoRepo.delete(userInfoID);
        return "deleted !! ";
    }

    @Override
    public String update(Long userId, UserInfo newuserInfo) {
        userInfoRepo.update(userId, newuserInfo);
        return "updated !! ";
    }

    @Override
    public UserInfo findUserInfoById(Long id) {
        return userInfoRepo.findUserInfoById(id);
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepo.findById(id);
    }


}
