package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.*;
import peaksoft.repo.PostRepo;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepoImpl implements PostRepo {
    @PersistenceContext
     private final EntityManager entityManager;
    @Override
    public String savePostByUser(Long userId, Post post) {
        User user = entityManager.find(User.class, userId);
        post.setUser(user);
        entityManager.persist(post);
        return "post !!";
    }
    @Override
    public List<Post> getAll() {
        return entityManager.createQuery("select p from Post p ",Post.class).getResultList();
    }
    @Override
    public Post findPostById(Long postId) {
        return entityManager.find(Post.class, postId);
    }

    @Override
    public void delete( Long postId) {
        Post post = entityManager.find(Post.class, postId);
        entityManager.remove(post);

//        entityManager.createQuery("SELECT p FROM Post p INNER JOIN p.user u WHERE u.id = :userId AND p.id = :postId")
//                .setParameter("userId",userID)
//                .setParameter("postId",postId)
//                .getSingleResult();

    }

    @Override
    public List<Post> getAllPostByUserId(Long id) {
        return entityManager.createQuery("select p from Post p where user.id = :id", Post.class)
                .setParameter("id", id).getResultList();
    }


}
