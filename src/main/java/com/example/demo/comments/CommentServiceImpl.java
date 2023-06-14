package com.example.demo.comments;

import com.example.demo.posts.Post;
import com.example.demo.posts.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Comment> get(int id) {
        return repository.findById(id);
    }

    @Override
    public Comment create(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Comment addComment(Integer postId, Comment comment) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isEmpty()) {
            throw new RuntimeException("Post with id " + postId + " not found");
        }

        comment.setPost(postOptional.get());

        return repository.save(comment);
    }

    @Override
    public List<Comment> getByPostId(Integer postId) {
      return repository.getByPostId(postId);
    }

    @Override
    public List<Comment> search(String keyword) {
        return repository.findByPostTitle(keyword.toUpperCase());
    }
}
