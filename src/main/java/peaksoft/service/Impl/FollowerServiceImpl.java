package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.controller.FollowerController;
import peaksoft.repo.FollowerRepo;
import peaksoft.service.FollowerService;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private final FollowerRepo followerRepo;
    @Override  // Подписчики
    public int Subscribers(Long followerId) {
        return followerRepo.Subscribers(followerId);
    }

    @Override   // Подписки
    public int Subscriptions(Long followerId) {
        return followerRepo.Subscriptions(followerId);
    }

    @Override
    public void following(Long currentUserId, Long foundUserId) {
        followerRepo.following(currentUserId,foundUserId);
    }
}
