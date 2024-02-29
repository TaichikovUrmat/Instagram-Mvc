package peaksoft.service;

import peaksoft.entity.Post;

import java.util.List;

public interface PostService {

    String savePostByUser(Long userId, Post post);
    List<Post> getAll();
    Post findPostById(Long postId);
    void delete(Long postId);
    List<Post> getAllPostByUserId(Long id);
}
