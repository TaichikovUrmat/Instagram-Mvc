package peaksoft.repo;

public interface FollowerRepo {

    int Subscribers(Long followerId);
    int Subscriptions(Long followerId);
    void following(Long currentUserId,Long foundUserId);
}
