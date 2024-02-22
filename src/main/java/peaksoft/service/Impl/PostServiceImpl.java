package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Image;
import peaksoft.entity.Post;
import peaksoft.repo.PostRepo;
import peaksoft.service.PostService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    @Override
    public String savePostByUser(Long userId, Post post) {

        String imageUrl = post.getImageUrl();
        Image image = new Image();
        image.setImageURL(imageUrl);
        image.setPost(post);
        post.addImage(image);
       return postRepo.savePostByUser(userId, post);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepo.findPostById(postId);
    }

    @Override
    public void delete(Long postId) {
        postRepo.delete(postId);
    }
}
