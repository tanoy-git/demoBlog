package com.example.demo.posts;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAll();

    Optional<Post> get(int id);

    Post create(Post post);

    void delete(int id);

    void update(Post post);


    List<Post> getBycategoryId(Integer categoryId);
}
