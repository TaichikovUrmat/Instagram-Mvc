package peaksoft.repo.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Comment;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repo.CommentRepo;

import java.util.List;


@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRepoImpl implements CommentRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public String saveComment(Long userId, Long postId, Comment comment) {
        User user = entityManager.find(User.class, userId);
        Post post = entityManager.find(Post.class, postId);
//        for (Post post : user.getPosts()) {
//            if(post.getId().equals(postId)){
//                post.getComment().add(comment);
//            }
//       }

        user.addComment(comment);
        post.addComment(comment);
        comment.setPosts(post);
        comment.getUsers().add(user);
        entityManager.persist(comment);
        return "comments !! ";
    }

    @Override
    public Comment finByCommentID(Long commentId) {
//        User user = entityManager.find(User.class, userId);
//        Post postt = entityManager.find(Post.class, post);
//        Comment comment = entityManager.find(Comment.class, commentId);
//
//        // Проверка на null, чтобы избежать NullPointerException
//        if (user != null && postt != null && comment != null) {
//            // Получить комментарии пользователя
//            List<Comment> userComments = user.getComments();
//
//            // Получить комментарии поста
//            List<Comment> postComments = postt.getComment();
//
//            // Дальнейшая логика работы с полученными данными
//            // ...
//            return comment;
//        }

        return entityManager.find(Comment.class,commentId);
    }


}
