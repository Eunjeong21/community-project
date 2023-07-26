package com.zerobase.communityproject.controller;

import com.zerobase.community.domain.entity.Article;
import com.zerobase.community.domain.entity.User;
import com.zerobase.community.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
  private final CommentService commentService;

  @PostMapping("/read/{articleNum}/comment")
  void createComment(@PathVariable Article articleNum, int commentNum, User id, String content) {
    commentService.createComment(articleNum, commentNum, id, content);
  }

  @PutMapping("/read/article/{commentNum}")
  void updateComment(@PathVariable int commentNum, Long articleNum, String content) {
    commentService.updateComment(articleNum, commentNum, content);
  }

  @DeleteMapping("/read/article/{commentNum}")
  void deleteComment(@PathVariable int commentNum) {
    commentService.deleteComment(commentNum);
  }
}
