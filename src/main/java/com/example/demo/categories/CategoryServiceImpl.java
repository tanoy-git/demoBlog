package com.example.demo.categories;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> get(int id) {
        return repository.findById(id);
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public void update(Category category) {
        repository.save(category);

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
