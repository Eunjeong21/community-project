package com.zerobase.communityproject.controller;

import com.zerobase.community.domain.entity.Article;
import com.zerobase.community.domain.entity.User;
import com.zerobase.community.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {
  private final ArticleService articleService;

  @PostMapping("create/article")
  void createArticle(@RequestBody Long articleNum, User id, String title, String content) {
    articleService.createArticle(articleNum, id, title, content);
  }

  @GetMapping("/read/article")
  List<Article> readArticle(Long articleNum) {
    return articleService.readArticle(articleNum);
  }

  @PutMapping("/update/article/{articleNum}")
  void updateArticle(@PathVariable Long articleNum, String title, String content) {
    articleService.updateArticle(articleNum, title, content);
  }

  @DeleteMapping("/delete/article/{articleNum}")
  void deleteArticle(@PathVariable Long articleNum) {
    articleService.deleteArticle(articleNum);
  }




}
