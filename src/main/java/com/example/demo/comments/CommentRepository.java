package com.example.demo.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select c from Comment c left join c.post p where UPPER(p.title) like %:postTitle%")
    List<Comment> findByPostTitle(@Param("postTitle") String postTitle);

    List<Comment> getByPostId(Integer postId);
}
