package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.service.CommentService;
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

  @PostMapping("/create/{articleNum}/comment")
  void createComment(@PathVariable Article articleNum, int commentNum, User id, String content) {
    commentService.createComment(articleNum, commentNum, id, content);
  }

  @PutMapping("/update/article/{commentNum}")
  void updateComment(@PathVariable int commentNum, Long articleNum, String content) {
    commentService.updateComment(articleNum, commentNum, content);
  }

  @DeleteMapping("/delete/article/{commentNum}")
  void deleteComment(@PathVariable int commentNum) {
    commentService.deleteComment(commentNum);
  }
}
