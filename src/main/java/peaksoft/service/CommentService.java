package peaksoft.service;

import peaksoft.entity.Comment;

public interface CommentService {
    String saveComment(Long userId, Long postId, Comment comment);
    Comment finByCommentID(Long commentId);

}
