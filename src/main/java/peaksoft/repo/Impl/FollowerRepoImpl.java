package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Follower;
import peaksoft.entity.User;
import peaksoft.repo.FollowerRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class FollowerRepoImpl implements FollowerRepo {

    @PersistenceContext
    private final EntityManager entityManager;
    @Override  // Подписчики
    public int Subscribers(Long followerId) {
        Follower follower = entityManager.find(Follower.class, followerId);
        return follower.getSubscribers().size();
    }

    @Override  // // Подписки
    public int Subscriptions(Long followerId) {
        Follower follower = entityManager.find(Follower.class, followerId);
        return follower.getSubscriptions().size();
    }

    @Override
    public void following(Long currentUserId, Long foundUserId) {

//        entityManager.getTransaction().begin();
        User userCurrent = entityManager.find(User.class, currentUserId);
        User foundUser = entityManager.find(User.class, foundUserId);

        List<Long> subscribers = foundUser.getFollower().getSubscribers();
        List<Long> subscriptions = userCurrent.getFollower().getSubscriptions();

        boolean foundUs = false;
        for (Long subscriptionId : subscriptions) {
            if( subscriptionId.equals(foundUserId)){
                subscriptions.remove(subscriptionId);
                foundUs = true;
                break;
            }

        }
        if (!foundUs) subscriptions.add(foundUserId);

        for (Long subscriber : subscribers) {
            if (subscriber.equals(currentUserId)) {
                subscribers.remove(subscriber);
                foundUs = true;
               break;
            }

        }
        if (!foundUs) subscribers.add(currentUserId);
//        entityManager.getTransaction().commit();

    }
   /// *****************   follower  ******************** ///





}
