package com.example.demo.categories;


import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> get(int id);

    Category create(Category category);

    void update(Category category);

    void delete(int id);


}
