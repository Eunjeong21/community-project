package com.zerobase.communityproject.controller;

import com.zerobase.communityproject.domain.entity.Article;
import com.zerobase.communityproject.domain.entity.User;
import com.zerobase.communityproject.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {
  private final ArticleService articleService;

  @PostMapping("/create/article-form")
  public String createArticleForm(Article article, User user) {
    articleService.createArticle(article, user);
    return "redirect:/article-list";
  }

  @PutMapping("/update/article/{articleNum}")
  public String updateArticleForm(@PathVariable Long articleNum, Article article) {
    articleService.updateArticle(articleNum, article);
    return "redirect:/article-list";
  }

  @DeleteMapping("/delete/article/{articleNum}")
  public String deleteArticle(@PathVariable Long articleNum) {
    articleService.deleteArticle(articleNum);
    return "redirect:/article-list";
  }
}
