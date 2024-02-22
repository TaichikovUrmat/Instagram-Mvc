package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Comment;
import peaksoft.repo.CommentRepo;
import peaksoft.service.CommentService;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    @Override
    public String saveComment(Long userId, Long postId, Comment comment) {

         commentRepo.saveComment(userId,postId, comment);
         return "commented !!";
    }

    @Override
    public Comment finByCommentID(Long commentId) {
        return commentRepo.finByCommentID(commentId);
    }
}
