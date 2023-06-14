package com.example.demo.comments;


import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAll();

    Optional<Comment> get(int id);

    Comment create(Comment comment);
    void update(Comment comment);
    void delete (int id);

    Comment addComment(Integer postId, Comment comment);

    List<Comment> getByPostId(Integer postId);

    List<Comment> search(String keyword);
}
