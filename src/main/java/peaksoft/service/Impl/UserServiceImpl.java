package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;
import peaksoft.repo.UserPepo;
import peaksoft.service.UserService;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPepo userPepo;

    @Override
    public String saveUser(User user) {
        return userPepo.saveUser(user);
    }

    @Override
    public User login(User user) throws Exception {
        return userPepo.login(user);
    }

    @Override
    public User findByUserId(Long userId) throws Exception {
        return userPepo.findByUserId(userId);
    }


}
