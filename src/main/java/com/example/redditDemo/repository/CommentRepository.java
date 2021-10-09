package com.example.redditDemo.repository;

import com.example.redditDemo.model.Comment;
import com.example.redditDemo.model.Post;
import com.example.redditDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}
