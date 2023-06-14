package com.example.demo.comments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service){
        this.service=service;
    }
    @PostMapping
    public ResponseEntity<Comment>create(@RequestBody Comment comment) {
        return new ResponseEntity<>(service.create(comment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>>getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment>getByID(@PathVariable Integer id){
        var commentOptional = service.get(id);

        return commentOptional.map(comment -> new ResponseEntity<>(comment, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add-comment/{postId}")
        public ResponseEntity<Comment> addComment(@PathVariable Integer postId, @RequestBody Comment comment)
    {
       var newComment= service.addComment(postId, comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @GetMapping("/get/{postId}")
        public ResponseEntity<List<Comment>> getByPostId (@PathVariable Integer postId){
        return new ResponseEntity<>(service.getByPostId(postId) , HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Comment>> search (@PathVariable String keyword){
        return new ResponseEntity<>(service.search(keyword) , HttpStatus.OK);
    }
}
