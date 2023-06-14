package com.example.demo.categories;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")

public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category>create(@RequestBody Category category){
        return new ResponseEntity<>(service.create(category), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Category>>getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Category>get(@PathVariable int id){
        var category=service.get(id).orElseThrow();
        return new ResponseEntity<>(category ,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Category category){
        category.setId(id);
        service.update(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
