package peaksoft.service;

public interface FollowerService {
    int Subscribers(Long followerId);
    int Subscriptions(Long followerId);
    void following(Long currentUserId,Long foundUserId);
}
