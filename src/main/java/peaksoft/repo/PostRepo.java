package peaksoft.repo;

import peaksoft.entity.Post;

import java.util.List;

public interface PostRepo {
    String savePostByUser(Long userId, Post post);
    List<Post> getAll();
    Post findPostById(Long postId);
    void delete(Long postId);
}
