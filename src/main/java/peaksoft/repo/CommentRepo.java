package peaksoft.repo;

import peaksoft.entity.Comment;

public interface CommentRepo {
    String saveComment(Long userId, Long postId, Comment comment);

    Comment finByCommentID(Long commentId);
}
