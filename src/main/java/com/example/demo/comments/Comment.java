package com.example.demo.comments;

import com.example.demo.posts.Post;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    @ManyToOne
    private Post post;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
