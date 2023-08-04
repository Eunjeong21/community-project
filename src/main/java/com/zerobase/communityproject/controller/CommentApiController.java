package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.dto.CommentDto;
import com.zerobase.communityproject.domain.dto.CommentUpdateDto;
import com.zerobase.communityproject.service.impl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
  private final CommentServiceImpl commentService;

  @PostMapping("/create/{articleNum}/comment")
  public String createComment(CommentDto commentDto) {
    commentService.createComment(commentDto);
    return "redirect:/article-detail";
  }

  @PutMapping("/update/article/{commentNum}")
  public String updateComment(CommentUpdateDto commentUpdateDto) {
    commentService.updateComment(commentUpdateDto);
    return "redirect:/article-detail";
  }

  @DeleteMapping("/delete/article/{commentNum}")
  public String deleteComment(@PathVariable int commentNum) {
    commentService.deleteComment(commentNum);
    return "redirect:/article-detail";
  }
}
