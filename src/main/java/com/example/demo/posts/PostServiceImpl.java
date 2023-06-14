package com.example.demo.posts;

import com.example.demo.categories.Category;
import com.example.demo.categories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Post> get(int id) {
        return repository.findById(id);
    }

    @Override
    public Post create(Post post) {

        Optional<Category> categoryOptional = categoryRepository.findById(30);

        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found");
        }

        post.setCategory(categoryOptional.get());
        return repository.save(post);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(Post post) {
        repository.save(post);

    }

    @Override
    public List<Post> getBycategoryId(Integer categoryId) {
        return repository.getByCategoryId(categoryId);
    }
}
